package thelm.packagedavaritia;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import thelm.packagedavaritia.client.event.ClientEventHandler;
import thelm.packagedavaritia.event.CommonEventHandler;

@Mod(PackagedAvaritia.MOD_ID)
public class PackagedAvaritia {

	public static final String MOD_ID = "packagedavaritia";

	public PackagedAvaritia() {
		CommonEventHandler.getInstance().onConstruct();
		DistExecutor.unsafeRunWhenOn(Dist.CLIENT, ()->()->{
			ClientEventHandler.getInstance().onConstruct();
		});
	}
}
