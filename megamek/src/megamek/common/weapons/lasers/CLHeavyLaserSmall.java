/*
 * MegaMek - Copyright (C) 2004 Ben Mazur (bmazur@sev.org)
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * for more details.
 */
package megamek.common.weapons.lasers;

import megamek.common.SimpleTechLevel;
import megamek.common.WeaponTypeFlag;

/**
 * @author Andrew Hunter
 * @since Sep 12, 2004
 */
public class CLHeavyLaserSmall extends LaserWeapon {
    private static final long serialVersionUID = -1717918421173868008L;

    public CLHeavyLaserSmall() {
        super();
        name = "Heavy Small Laser";
        setInternalName("CLHeavySmallLaser");
        addLookupName("Clan Small Heavy Laser");
        sortingName = "Laser Heavy B";
        heat = 3;
        damage = 6;
        toHitModifier = 1;
        shortRange = 1;
        mediumRange = 2;
        longRange = 3;
        extremeRange = 4;
        waterShortRange = 1;
        waterMediumRange = 2;
        waterLongRange = 2;
        waterExtremeRange = 2;
        tonnage = 0.5;
        criticals = 1;
        bv = 15;
        cost = 20000;
        shortAV = 6;
        maxRange = RANGE_SHORT;
        flags = flags.or(WeaponTypeFlag.HEAVY_LASER);
        rulesRefs = "226, TM";
        //Jan 22 - Errata issued by CGL (Greekfire) for Heavy Lasers
        techAdvancement.setTechBase(TechBase.CLAN)
                .setIntroLevel(false)
                .setUnofficial(false)
                .setTechRating(TechRating.F)
                .setAvailability(AvailabilityValue.X, AvailabilityValue.X, AvailabilityValue.D, AvailabilityValue.D)
                .setClanAdvancement(3057, 3058, 3059, DATE_NONE, DATE_NONE)
                .setClanApproximate(false, false, false, false, false)
                .setPrototypeFactions(Faction.CBR, Faction.CSA)
                .setProductionFactions(Faction.CSA)
                .setStaticTechLevel(SimpleTechLevel.STANDARD);
    }

    @Override
    public boolean isAlphaStrikePointDefense() {
        return true;
    }
}
