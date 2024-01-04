package com.hlysine.create_power_loader.content.andesitechunkloader;


import com.hlysine.create_power_loader.CPLBlocks;
import com.hlysine.create_power_loader.CPLPartialModels;
import com.hlysine.create_power_loader.config.CPLConfigs;
import com.hlysine.create_power_loader.content.AbstractChunkLoaderRenderer;
import com.jozufozu.flywheel.core.PartialModel;
import com.simibubi.create.content.contraptions.behaviour.MovementContext;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.item.ItemStack;

public class AndesiteChunkLoaderRenderer extends AbstractChunkLoaderRenderer {

    public AndesiteChunkLoaderRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected PartialModel getCorePartial(boolean attached, boolean active) {
        if (attached) {
            return active
                    ? CPLPartialModels.ANDESITE_CORE_ATTACHED_ACTIVE
                    : CPLPartialModels.ANDESITE_CORE_ATTACHED_INACTIVE;
        } else {
            return active
                    ? CPLPartialModels.ANDESITE_CORE_ACTIVE
                    : CPLPartialModels.ANDESITE_CORE_INACTIVE;
        }
    }

    @Override
    protected boolean shouldFunctionOnContraption(MovementContext context) {
        return CPLConfigs.server().andesiteOnContraption.get() &&
                !context.contraption.isActorTypeDisabled(CPLBlocks.ANDESITE_CHUNK_LOADER.asStack()) &&
                !context.contraption.isActorTypeDisabled(ItemStack.EMPTY);
    }
}
