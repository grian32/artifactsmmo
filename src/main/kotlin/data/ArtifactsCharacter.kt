package me.grian.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import me.grian.data.InventoryItem

@Serializable
data class ArtifactsCharacter(
    val name: String,
    val account: String,
    val skin: String,
    val level: Int,
    val xp: Int,
    @SerialName("max_xp")
    val maxXp: Int,
    val gold: Int,
    val speed: Int,
    @SerialName("mining_level")
    val miningLevel: Int,
    @SerialName("mining_xp")
    val miningXp: Int,
    @SerialName("mining_max_xp")
    val miningMaxXp: Int,
    @SerialName("woodcutting_level")
    val woodcuttingLevel: Int,
    @SerialName("woodcutting_xp")
    val woodcuttingXp: Int,
    @SerialName("woodcutting_max_xp")
    val woodcuttingMaxXp: Int,
    @SerialName("fishing_level")
    val fishingLevel: Int,
    @SerialName("fishing_xp")
    val fishingXp: Int,
    @SerialName("fishing_max_xp")
    val fishingMaxXp: Int,
    @SerialName("weaponcrafting_level")
    val weaponcraftingLevel: Int,
    @SerialName("weaponcrafting_xp")
    val weaponcraftingXp: Int,
    @SerialName("weaponcrafting_max_xp")
    val weaponcraftingMaxXp: Int,
    @SerialName("gearcrafting_level")
    val gearcraftingLevel: Int,
    @SerialName("gearcrafting_xp")
    val gearcraftingXp: Int,
    @SerialName("gearcrafting_max_xp")
    val gearcraftingMaxXp: Int,
    @SerialName("jewelrycrafting_level")
    val jewelrycraftingLevel: Int,
    @SerialName("jewelrycrafting_xp")
    val jewelrycraftingXp: Int,
    @SerialName("jewelrycrafting_max_xp")
    val jewelrycraftingMaxXp: Int,
    @SerialName("cooking_level")
    val cookingLevel: Int,
    @SerialName("cooking_xp")
    val cookingXp: Int,
    @SerialName("cooking_max_xp")
    val cookingMaxXp: Int,
    @SerialName("alchemy_level")
    val alchemyLevel: Int,
    @SerialName("alchemy_xp")
    val alchemyXp: Int,
    @SerialName("alchemy_max_xp")
    val alchemyMaxXp: Int,
    val hp: Int,
    @SerialName("max_hp")
    val maxHp: Int,
    val haste: Int,
    @SerialName("critical_strike")
    val criticalStrike: Int,
    val wisdom: Int,
    val prospecting: Int,
    @SerialName("attack_fire")
    val attackFire: Int,
    @SerialName("attack_earth")
    val attackEarth: Int,
    @SerialName("attack_water")
    val attackWater: Int,
    @SerialName("attack_air")
    val attackAir: Int,
    val dmg: Int,
    @SerialName("dmg_fire")
    val dmgFire: Int,
    @SerialName("dmg_earth")
    val dmgEarth: Int,
    @SerialName("dmg_water")
    val dmgWater: Int,
    @SerialName("dmg_air")
    val dmgAir: Int,
    @SerialName("res_fire")
    val resFire: Int,
    @SerialName("res_earth")
    val resEarth: Int,
    @SerialName("res_water")
    val resWater: Int,
    @SerialName("res_air")
    val resAir: Int,
    val x: Int,
    val y: Int,
    val cooldown: Int,
    @SerialName("cooldown_expiration")
    val cooldownExpiration: String,
    @SerialName("weapon_slot")
    val weaponSlot: String,
    @SerialName("rune_slot")
    val runeSlot: String,
    @SerialName("shield_slot")
    val shieldSlot: String,
    @SerialName("helmet_slot")
    val helmetSlot: String,
    @SerialName("body_armor_slot")
    val bodyArmorSlot: String,
    @SerialName("leg_armor_slot")
    val legArmorSlot: String,
    @SerialName("boots_slot")
    val bootsSlot: String,
    @SerialName("ring1_slot")
    val ring1Slot: String,
    @SerialName("ring2_slot")
    val ring2Slot: String,
    @SerialName("amulet_slot")
    val amuletSlot: String,
    @SerialName("artifact1_slot")
    val artifact1Slot: String,
    @SerialName("artifact2_slot")
    val artifact2Slot: String,
    @SerialName("artifact3_slot")
    val artifact3Slot: String,
    @SerialName("utility1_slot")
    val utility1Slot: String,
    @SerialName("utility1_slot_quantity")
    val utility1SlotQuantity: Int,
    @SerialName("utility2_slot")
    val utility2Slot: String,
    @SerialName("utility2_slot_quantity")
    val utility2SlotQuantity: Int,
    @SerialName("bag_slot")
    val bagSlot: String,
    val task: String,
    @SerialName("task_type")
    val taskType: String,
    @SerialName("task_progress")
    val taskProgress: Int,
    @SerialName("task_total")
    val taskTotal: Int,
    @SerialName("inventory_max_items")
    val inventoryMaxItems: Int,
    val inventory: List<InventoryItem>,
)