package br.com.vitorcapovilla.Fake;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static br.com.vitorcapovilla.Fake.RandomNickname.generateRandomName;

public class Fake implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("fake.use")){
            sender.sendMessage("§1[FakeCapovilla]§r§b Você não tem permissão para executar este comando.");
            return true;
        }

        try {
            setPlayerName((Player)sender, args[0]);
        }catch (ArrayIndexOutOfBoundsException e){
           sender.sendMessage("§1[FakeCapovilla]§r§b Use '/fake help' para mais detalhes!");
        }
        return true;
    }

    public void setPlayerName(Player p, String name){
        if (name.isEmpty()){
            p.sendMessage("§1[FakeCapovilla]§r§b Use '/fake help' para mais detalhes!");
        }else if(name.equals("*")){
            // Caso /fake sem argumentos, voltar ao nick original
            p.setDisplayName(p.getName());
            p.setPlayerListName(p.getName());
            p.sendMessage("§1[FakeCapovilla]§r§b Seu nome foi restaurado para " + p.getName());
        }else if(name.equalsIgnoreCase("random")){
            // Caso /fake random, usar um nome aleatório
            String randomNickname = generateRandomName();
            p.setDisplayName(randomNickname);
            p.setPlayerListName(randomNickname);
            p.sendMessage("§1[FakeCapovilla]§r§b Seu nome foi alterado para " + randomNickname);
        } else if (name.equalsIgnoreCase("help")) {
            p.sendMessage("§2---§1[FakeCapovilla HELPER]§2---");
            p.sendMessage("§1[FakeCapovilla]§r§b Use /fake random -> para alterar seu nick para um aleatório");
            p.sendMessage("§1[FakeCapovilla]§r§b Use /fake {nick} -> para alterar seu nick para o que foi digitado");
            p.sendMessage("§1[FakeCapovilla]§r§b Use /fake * -> para resetar seu nick ao original");
            p.sendMessage("§2---§1[FakeCapovilla HELPER]§2---");
        } else{
            // Caso /fake com um argumento, usar o nome especificado
            String newName = name;
            p.setDisplayName(newName);
            p.setPlayerListName(newName);
            p.sendMessage("§1[FakeCapovilla]§r§b Seu nome foi alterado para " + newName);
        }
    }
}