package org.hive2hive.core.process.login;

import org.hive2hive.core.IFileConfiguration;
import org.hive2hive.core.file.FileManager;
import org.hive2hive.core.model.Locations;
import org.hive2hive.core.network.data.UserProfileManager;
import org.hive2hive.core.process.context.ProcessContext;
import org.hive2hive.core.security.UserCredentials;

public class PostLoginProcessContext extends ProcessContext {

	private final UserProfileManager profileManager;
	private Locations locations;
	private boolean isElectedMaster = false;
	private final FileManager fileManager;
	private final IFileConfiguration fileConfig;

	public PostLoginProcessContext(PostLoginProcess postLoginProcess, UserProfileManager profileManager,
			Locations currentLocations, FileManager fileManager, IFileConfiguration fileConfig) {
		super(postLoginProcess);
		this.profileManager = profileManager;
		this.locations = currentLocations;
		this.fileManager = fileManager;
		this.fileConfig = fileConfig;
	}

	public void setNewLocations(Locations newLocations) {
		this.locations = newLocations;
	}

	/**
	 * Defines whether client is elected as master client.
	 * 
	 * @param isDefinedAsMaster True, if this client is the master client.
	 */
	public void setIsElectedMaster(boolean isDefinedAsMaster) {
		this.isElectedMaster = isDefinedAsMaster;
	}

	/**
	 * Gets whether this client is elected as master client.
	 * 
	 * @return True, if this client is the master client.
	 */
	public boolean getIsDefinedAsMaster() {
		return isElectedMaster;
	}

	public UserProfileManager getProfileManager() {
		return profileManager;
	}

	public UserCredentials getCredentials() {
		return profileManager.getUserCredentials();
	}

	public Locations getLocations() {
		return locations;
	}

	public FileManager getFileManager() {
		return fileManager;
	}

	public IFileConfiguration getFileConfig() {
		return fileConfig;
	}
}
