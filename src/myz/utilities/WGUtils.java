/**
 * 
 */
package myz.utilities;

import org.bukkit.Location;

import com.sk89q.worldguard.bukkit.WGBukkit;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.DefaultFlag;

/**
 * @author Jordan
 * 
 */
public class WGUtils {

	/**
	 * Whether or not the location is in a WorldGuard region flagged for
	 * amplified mob spawns.
	 * 
	 * @param inLocation
	 *            The location.
	 * @return True if the location is in a WorldGuard flagged region.
	 */
	public static boolean isAmplifiedRegion(Location inLocation) {
		if (WGBukkit.getRegionManager(inLocation.getWorld()) == null)
			return false;

		ApplicableRegionSet region = WGBukkit.getRegionManager(inLocation.getWorld()).getApplicableRegions(inLocation);
		return region.allows(DefaultFlag.CHEST_ACCESS);
	}

	/**
	 * Whether or not a region alows mob spawning.
	 * 
	 * @param inLocation
	 *            The location.
	 * @return True if mob spawning is allowed.
	 */
	public static boolean isMobSpawning(Location inLocation) {
		if (WGBukkit.getRegionManager(inLocation.getWorld()) == null)
			return false;

		ApplicableRegionSet region = WGBukkit.getRegionManager(inLocation.getWorld()).getApplicableRegions(inLocation);
		return region.allows(DefaultFlag.MOB_SPAWNING);
	}
}
