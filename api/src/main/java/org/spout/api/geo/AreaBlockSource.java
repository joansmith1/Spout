/*
 * This file is part of Spout.
 *
 * Copyright (c) 2011 Spout LLC <http://www.spout.org/>
 * Spout is licensed under the Spout License Version 1.
 *
 * Spout is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option)
 * any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the Spout License Version 1.
 *
 * Spout is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License for
 * more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the Spout License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://spout.in/licensev1> for the full license, including
 * the MIT license.
 */
package org.spout.api.geo;

import org.spout.api.generator.biome.Biome;
import org.spout.api.material.BlockMaterial;
import org.spout.api.util.thread.annotation.LiveRead;

public interface AreaBlockSource {
	/**
	 * Gets the material for the block at (x, y, z)
	 *
	 * @param x coordinate of the block
	 * @param y coordinate of the block
	 * @param z coordinate of the block
	 * @return the block's material from the snapshot
	 */
	@LiveRead
	public BlockMaterial getBlockMaterial(int x, int y, int z);

	/**
	 * Gets the packed BlockFullData for the block at (x, y, z). Handler methods are provided by the BlockFullState class.
	 *
	 * @param x coordinate of the block
	 * @param y coordinate of the block
	 * @param z coordinate of the block
	 * @return the block's full state from the snapshot
	 */
	@LiveRead
	public int getBlockFullState(int x, int y, int z);

	/**
	 * Gets the data for the block at (x, y, z)
	 *
	 * @param x coordinate of the block
	 * @param y coordinate of the block
	 * @param z coordinate of the block
	 * @return the block's data from the snapshot
	 */
	@LiveRead
	public short getBlockData(int x, int y, int z);

	/**
	 * Gets the biome type at the coordinates. Returns {@code null} if no biomes are present.
	 *
	 * @param x coordinate of the block
	 * @param y coordinate of the block
	 * @param z coordinate of the block
	 * @return The biome type at the location, or null if no biome exists.
	 */
	public Biome getBiome(int x, int y, int z);
}