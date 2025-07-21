package thelm.packagedavaritia.variant;

public enum AvaritiaVariant {

	UNIVERSAL("Avaritia Universal", "PackagedAvaritia:Universal", "avaritia.Avaritia"),
	NEO("AvaritiaNeo", "PackagedAvaritia:Neo", "net.byAqua3.avaritia.Avaritia"),
	RE("Re:Avaritia", "PackagedAvaritia:Re", "committee.nova.mods.avaritia.Avaritia"),

	FABRIC("Avaritia Fabric", null, "net.laith.avaritia.AvaritiaMod"),
	REBORN("AvaritiaReborn", null, "com.iafenvoy.avaritia.AvaritiaReborn"),

	LITE("Avaritia Lite", null, "net.bullfighter.avaritia.AvaritiaMod"),
	RESET("Avaritia Reset Version", null, "net.jin.avaritia.AvaritiaMod"),
	;

	public final String avaritiaVariant;
	public final String modVariant;
	public final String mainClass;

	AvaritiaVariant(String avaritiaVariant, String modVariant, String mainClass) {
		this.avaritiaVariant = avaritiaVariant;
		this.modVariant = modVariant;
		this.mainClass = mainClass;
	}
}
