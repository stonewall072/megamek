/*
 * MegaMek - Copyright (C) 2004, 2005 Ben Mazur (bmazur@sev.org)
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
package megamek.common.weapons.ppc;

import megamek.common.AmmoType;
import megamek.common.alphaStrike.AlphaStrikeElement;
import megamek.common.Game;
import megamek.common.ToHitData;
import megamek.common.actions.WeaponAttackAction;
import megamek.common.weapons.AmmoWeapon;
import megamek.common.weapons.AttackHandler;
import megamek.common.weapons.PlasmaRifleHandler;
import megamek.server.totalwarfare.TWGameManager;

/**
 * @author Sebastian Brocks
 * @since May 29, 2004
 */
public class ISPlasmaRifle extends AmmoWeapon {
    private static final long serialVersionUID = -7919371014161089388L;

    public ISPlasmaRifle() {
        name = "Plasma Rifle";
        setInternalName("ISPlasmaRifle");
        heat = 10;
        damage = 10;
        rackSize = 1;
        ammoType = AmmoType.AmmoTypeEnum.PLASMA;
        minimumRange = WEAPON_NA;
        shortRange = 5;
        mediumRange = 10;
        longRange = 15;
        extremeRange = 20;
        tonnage = 6.0;
        criticals = 2;
        flags = flags.or(F_MEK_WEAPON).or(F_TANK_WEAPON).or(F_AERO_WEAPON)
                .or(F_PLASMA).or(F_DIRECT_FIRE).or(F_ENERGY);
        bv = 210;
        cost = 260000;
        shortAV = 10;
        medAV = 10;
        maxRange = RANGE_MED;
        atClass = CLASS_PLASMA;
        rulesRefs = "234, TM";
        techAdvancement.setTechBase(TechBase.IS)
                .setIntroLevel(false)
                .setUnofficial(false)
                .setTechRating(TechRating.E)
                .setAvailability(AvailabilityValue.X, AvailabilityValue.X, AvailabilityValue.E, AvailabilityValue.D)
                .setISAdvancement(3061, 3068, 3072, DATE_NONE, DATE_NONE)
                .setISApproximate(true, false, false, false, false)
                .setPrototypeFactions(Faction.CC)
                .setProductionFactions(Faction.CC);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * megamek.common.weapons.Weapon#getCorrectHandler(megamek.common.ToHitData,
     * megamek.common.actions.WeaponAttackAction, megamek.common.Game,
     * megamek.server.Server)
     */
    @Override
    protected AttackHandler getCorrectHandler(ToHitData toHit, WeaponAttackAction waa, Game game,
                                              TWGameManager manager) {
        return new PlasmaRifleHandler(toHit, waa, game, manager);
    }

    @Override
    public int getAlphaStrikeHeatDamage(int rangeband) {
        return (rangeband <= AlphaStrikeElement.RANGE_BAND_MEDIUM) ? 3 : 0;
    }
}
