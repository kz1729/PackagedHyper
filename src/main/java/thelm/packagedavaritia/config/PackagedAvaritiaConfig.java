package thelm.packagedavaritia.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import thelm.packagedavaritia.block.entity.ExtremeCrafterBlockEntity;

public class PackagedAvaritiaConfig {

	private PackagedAvaritiaConfig() {}

	private static ForgeConfigSpec serverSpec;

	public static ForgeConfigSpec.IntValue extremeCrafterEnergyCapacity;
	public static ForgeConfigSpec.IntValue extremeCrafterEnergyReq;
	public static ForgeConfigSpec.IntValue extremeCrafterEnergyUsage;
	public static ForgeConfigSpec.BooleanValue extremeCrafterDrawMEEnergy;

	public static void registerConfig() {
		buildConfig();
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, serverSpec);
	}

	private static void buildConfig() {
		ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

		builder.push("extreme_crafter");
		builder.comment("How much FE the Extreme Package Crafter should hold.");
		extremeCrafterEnergyCapacity = builder.defineInRange("energy_capacity", 5000, 0, Integer.MAX_VALUE);
		builder.comment("How much total FE the Extreme Package Crafter should use per operation.");
		extremeCrafterEnergyReq = builder.defineInRange("energy_req", 5000, 0, Integer.MAX_VALUE);
		builder.comment("How much FE/t maximum the Extreme Package Crafter can use.");
		extremeCrafterEnergyUsage = builder.defineInRange("energy_usage", 500, 0, Integer.MAX_VALUE);
		builder.comment("Should the Extreme Package Crafter draw energy from ME systems.");
		extremeCrafterDrawMEEnergy = builder.define("draw_me_energy", true);
		builder.pop();

		serverSpec = builder.build();
	}

	public static void reloadServerConfig() {
		ExtremeCrafterBlockEntity.energyCapacity = extremeCrafterEnergyCapacity.get();
		ExtremeCrafterBlockEntity.energyReq = extremeCrafterEnergyReq.get();
		ExtremeCrafterBlockEntity.energyUsage = extremeCrafterEnergyUsage.get();
		ExtremeCrafterBlockEntity.drawMEEnergy = extremeCrafterDrawMEEnergy.get();
	}
}
