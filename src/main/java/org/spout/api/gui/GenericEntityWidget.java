/*
 * This file is part of SpoutAPI (http://www.spout.org/).
 *
 * SpoutAPI is licensed under the SpoutDev license version 1.
 *
 * SpoutAPI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the SpoutDev License Version 1.
 *
 * SpoutAPI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the SpoutDev license version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://getspout.org/SpoutDevLicenseV1.txt> for the full license,
 * including the MIT license.
 */
package org.spout.api.gui;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.spout.api.ClientOnly;

public class GenericEntityWidget extends AbstractInline implements EntityWidget {

	/** Current version for serialisation and packet handling.*/
	private static final long serialVersionUID = 0L;
	private int entityId = 0;

	public GenericEntityWidget() {
	}

	public GenericEntityWidget(int entityId) {
		setEntityId(entityId);
	}

	public GenericEntityWidget(int width, int height) {
		super(width, height);
	}

	public GenericEntityWidget(int width, int height, int entityId) {
		super(width, height);
		setEntityId(entityId);
	}

	public GenericEntityWidget(int X, int Y, int width, int height) {
		super(X, Y, width, height);
	}

	public GenericEntityWidget(int X, int Y, int width, int height, int entityId) {
		super(X, Y, width, height);
		setEntityId(entityId);
	}

	@Override
	public WidgetType getType() {
		return WidgetType.EntityWidget;
	}

	@Override
	public EntityWidget setEntityId(int id) {
		if (entityId != id) {
			entityId = id;
			autoDirty();
		}
		return this;
	}

	@Override
	public int getEntityId() {
		return entityId;
	}

	@Override
	public void readData(DataInputStream input) throws IOException {
		super.readData(input);
		entityId = input.readInt();
	}

	@Override
	public void writeData(DataOutputStream output) throws IOException {
		super.writeData(output);
		output.writeInt(entityId);
	}

	@Override
	public EntityWidget copy() {
		return ((EntityWidget) super.copy()).setEntityId(getEntityId());
	}

	@Override
	public int getVersion() {
		return super.getVersion() + (int) serialVersionUID;
	}

	@Override
	@ClientOnly
	public void render() {
//		Spoutcraft.getClient().getRenderDelegate().render(this);
	}
}
