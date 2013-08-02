/*
 * Copyright (C) 2013 INRIA
 *
 * This software is governed by the CeCILL-C License under French law and
 * abiding by the rules of distribution of free software. You can use, modify
 * and/or redistribute the software under the terms of the CeCILL-C license as
 * circulated by CEA, CNRS and INRIA at http://www.cecill.info.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the CeCILL-C License for more details.
 *
 * The fact that you are presently reading this means that you have had
 * knowledge of the CeCILL-C license and that you accept its terms.
 */
package fr.inria.lille.jefix.patch;

import java.io.File;

import fr.inria.lille.jefix.SourceLocation;

/**
 * @author Favio D. DeMarco
 * 
 */
public class StringPatch implements Patch {

	private final SourceLocation location;

	private final String repair;

	/**
	 * @param repair
	 * @param location
	 */
	public StringPatch(final String repair, final SourceLocation location) {
		this.repair = repair;
		this.location = location;
	}

	/**
	 * @see fr.inria.lille.jefix.patch.Patch#asString()
	 */
	@Override
	public String asString() {
		return this.repair;
	}

	/**
	 * @see fr.inria.lille.jefix.patch.Patch#getFile()
	 */
	@Override
	public File getFile(final String sourceFolder) {
		return this.location.getSourceFile(sourceFolder);
	}

	/**
	 * @see fr.inria.lille.jefix.patch.Patch#getLineNumber()
	 */
	@Override
	public int getLineNumber() {
		return this.location.getLineNumber();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("%s:%d: %s", this.location.getContainingClassName(), this.getLineNumber(), this.repair);
	}
}