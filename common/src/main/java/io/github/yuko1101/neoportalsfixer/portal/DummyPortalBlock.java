package io.github.yuko1101.neoportalsfixer.portal;

import net.minecraft.block.Block;

import java.util.Properties;

public class DummyPortalBlock extends Block {

    public static final String ID = "dummy_portal_block";

    public DummyPortalBlock(Settings settings) {
        super(settings);
    }

    public DummyPortalBlock() {
        super(Settings.create());
    }
}
