package thelm.packagedavaritia.variant;

public class VariantChecker {

	public static final AvaritiaVariant VARIANT = AvaritiaVariant.NEO;

	public static final String SUPPORTED_MESSAGE = "%s only supports %s; %s is currently installed, which is supported by %s.";
	public static final String UNSUPPORTED_MESSAGE = "%s only supports %s; %s is currently installed.";
	public static final String DEFAULT_MESSAGE = "%s only supports %s; an unknown variant of Avaritia is currently installed.";

	public static void check() {
		if(classExists(VARIANT.mainClass)) {
			return;
		}
		for(AvaritiaVariant variant : AvaritiaVariant.values()) {
			if(variant == VARIANT) {
				continue;
			}
			if(classExists(variant.mainClass)) {
				if(variant.modVariant != null) {
					throw new VariantMismatchException(String.format(
							SUPPORTED_MESSAGE,
							VARIANT.modVariant, VARIANT.avaritiaVariant, variant.avaritiaVariant, variant.modVariant));
				}
				else {
					throw new VariantMismatchException(String.format(
							UNSUPPORTED_MESSAGE,
							VARIANT.modVariant, VARIANT.avaritiaVariant, variant.avaritiaVariant));
				}
			}
		}
		throw new VariantMismatchException(String.format(
				DEFAULT_MESSAGE,
				VARIANT.modVariant, VARIANT.avaritiaVariant));
	}

	public static boolean classExists(String className) {
		try {
			Class.forName(className);
			return true;
		}
		catch(ClassNotFoundException e) {
			return false;
		}
	}
}
