package dev.bnj.sweetpotato;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SweetPotatoBlock extends CropBlock {
    public static final MapCodec<SweetPotatoBlock> CODEC = simpleCodec(SweetPotatoBlock::new);
    private static final VoxelShape[] SHAPES = Block.boxes(7, i -> Block.column(16.0, 0.0, 2 + i));

    public SweetPotatoBlock(Properties properties) {
        super(properties);
    }

    @Override
    public MapCodec<SweetPotatoBlock> codec() {
        return CODEC;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return SweetPotatoMod.SWEET_POTATO;
    }

    @Override
    protected VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPES[this.getAge(blockState)];
    }
}
