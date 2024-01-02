package io.github.yuko1101.neoportalsfixer;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.block.Block;

public class NeoPortalsFixer {
	public static final String MOD_ID = "neoportalsfixer";

	public static void init() {
	}

	@ExpectPlatform
	public static Block getDummyPortalBlock() {
		throw new AssertionError();
	}
}
