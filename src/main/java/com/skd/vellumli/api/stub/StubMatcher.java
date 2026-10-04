package com.skd.vellumli.api.stub;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import com.skd.vellumli.api.IStateMatcher;
import com.skd.vellumli.api.TriPredicate;

public final class StubMatcher implements IStateMatcher {

	public static final StubMatcher INSTANCE = new StubMatcher();

	private final BlockState state = Blocks.AIR.defaultBlockState();

	private StubMatcher() {}

	@Override
	public BlockState getDisplayedState(long ticks) {
		return state;
	}

	@Override
	public TriPredicate<BlockGetter, BlockPos, BlockState> getStatePredicate() {
		return (w, p, s) -> false;
	}

}
