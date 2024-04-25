package br.com.vitorcapovilla.Fake;

import java.util.Random;

public class RandomNickname {
    private static final String[] nomes = {
            "Golldii", "DrSW99", "AwAkiiE", "LcGitech", "ItzMath", "Sleepyy", "", "GuerreiroLendario",
            "ReiDaMina", "DragaoDeFerro", "MestreDasSombras", "CavaleiroCelestial", "ShadowFighter", "StarExplorer",
            "CosmicCrafter", "DiamondDigger", "IronWarrior", "ElementalElder", "SolarSorcerer", "PhantomPharaoh", "", "MysticMage",
            "EternalEclipse", "NovaKnight", "FrostFang", "EmberEmpress", "ThunderTitan", "LunarLancer", "", "NebulaNinja",
            "GalacticGuardian", "CrystalCaster", "BlazeBard", "FrostbiteFury", "CelestialChampion", "ShadowShaman", "", "RuneRanger",
            "WildfireWarlock", "FrostbornFalcon", "StormySorcerer", "EclipseEnchanter"
    };

    public static String generateRandomName() {
        Random random = new Random();
        int index = random.nextInt(nomes.length);
        return nomes[index];
    }
}
