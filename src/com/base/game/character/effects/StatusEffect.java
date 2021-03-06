package com.base.game.character.effects;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.base.game.Weather;
import com.base.game.character.GameCharacter;
import com.base.game.character.QuestLine;
import com.base.game.character.SexualOrientation;
import com.base.game.character.attributes.Attribute;
import com.base.game.character.attributes.ArousalLevel;
import com.base.game.character.attributes.CorruptionLevel;
import com.base.game.character.attributes.FitnessLevel;
import com.base.game.character.attributes.IntelligenceLevel;
import com.base.game.character.attributes.StrengthLevel;
import com.base.game.character.body.types.PenisType;
import com.base.game.character.body.types.VaginaType;
import com.base.game.character.body.valueEnums.Capacity;
import com.base.game.character.body.valueEnums.CupSize;
import com.base.game.character.npc.NPC;
import com.base.game.character.race.Race;
import com.base.game.character.race.RaceStage;
import com.base.game.combat.DamageType;
import com.base.game.dialogue.utils.UtilText;
import com.base.game.inventory.clothing.AbstractClothing;
import com.base.game.inventory.clothing.ClothingSet;
import com.base.game.inventory.clothing.CoverableArea;
import com.base.game.sex.LubricationType;
import com.base.game.sex.OrificeType;
import com.base.game.sex.Sex;
import com.base.main.Main;
import com.base.rendering.SVGImages;
import com.base.utils.Colour;
import com.base.utils.Util;
import com.base.utils.Util.ListValue;
import com.base.utils.Util.Value;

/**
 * @since 0.1.0
 * @version 0.1.79
 * @author Innoxia
 */
public enum StatusEffect {

	// Attribute-related status effects:
	// Strength:
	STRENGTH_PERK_0(
			100,
			"sissy",
			"attStrength0",
			Colour.STRENGTH_STAGE_ZERO,
			false,
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.DAMAGE_PURE, -15f),
					new Value<Attribute, Float>(Attribute.RESISTANCE_PURE, -15f)),
			null) {
		
		@Override
		public String getName(GameCharacter target) {
			return Util.capitaliseSentence(StrengthLevel.ZERO_WEAK.getName());
		}
		
		@Override
		public String getDescription(GameCharacter target) {
			if (target.isPlayer())
				return "You are incredibly weak. You struggle to do much damage with your wimpy little "+target.getArmName()+", and your fragile body is vulnerable to all damage sources.";
			else
				return UtilText.genderParsing(target, target.getName("The") + "is incredibly weak."
						+ " <She> struggles to do much damage with <her> wimpy little "+target.getArmName()+", and <her> fragile body is vulnerable to all damage sources.");
		}

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return StrengthLevel.getStrengthLevelFromValue(target.getAttributeValue(Attribute.STRENGTH)) == StrengthLevel.ZERO_WEAK;
		}
		
		@Override
		public boolean renderInEffectsPanel() {
			return false;
		}
	},
	STRENGTH_PERK_1(
			100,
			"average",
			"attStrength1",
			Colour.STRENGTH_STAGE_ONE,
			true,
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.DAMAGE_PHYSICAL, 5f),
					new Value<Attribute, Float>(Attribute.CRITICAL_DAMAGE, 5f)),
			null) {
		
		@Override
		public String getName(GameCharacter target) {
			return Util.capitaliseSentence(StrengthLevel.ONE_AVERAGE.getName());
		}
		
		@Override
		public String getDescription(GameCharacter target) {
			if (target.isPlayer())
				return "You have an average level of strength for a human.";
			else
				return UtilText.genderParsing(target, target.getName("The") + " is about as strong as an average human.");
		}

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return StrengthLevel.getStrengthLevelFromValue(target.getAttributeValue(Attribute.STRENGTH)) == StrengthLevel.ONE_AVERAGE;
		}
		
		@Override
		public boolean renderInEffectsPanel() {
			return false;
		}
	},
	STRENGTH_PERK_2(
			100,
			"strong",
			"attStrength2",
			Colour.STRENGTH_STAGE_TWO,
			true,
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.DAMAGE_PHYSICAL, 10f),
					new Value<Attribute, Float>(Attribute.CRITICAL_DAMAGE, 10f)),
			null) {
		
		@Override
		public String getName(GameCharacter target) {
			return Util.capitaliseSentence(StrengthLevel.TWO_STRONG.getName());
		}
		
		@Override
		public String getDescription(GameCharacter target) {
			if (target.isPlayer())
				return "You are stronger than an average human.";
			else
				return UtilText.genderParsing(target, target.getName("The") + " is stronger than an average human.");
		}

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return StrengthLevel.getStrengthLevelFromValue(target.getAttributeValue(Attribute.STRENGTH)) == StrengthLevel.TWO_STRONG;
		}
		
		@Override
		public boolean renderInEffectsPanel() {
			return false;
		}
	},
	STRENGTH_PERK_3(
			100,
			"powerful",
			"attStrength3",
			Colour.STRENGTH_STAGE_THREE,
			true,
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.DAMAGE_PHYSICAL, 15f),
					new Value<Attribute, Float>(Attribute.CRITICAL_DAMAGE, 15f)),
			null) {
		
		@Override
		public String getName(GameCharacter target) {
			return Util.capitaliseSentence(StrengthLevel.THREE_POWERFUL.getName());
		}
		
		@Override
		public String getDescription(GameCharacter target) {
			if (target.isPlayer())
				return "You are stronger than even an average horse-boy, and, when compared to an average human, you are on the same level as a bodybuilder.";
			else
				return UtilText.genderParsing(target, target.getName("The") + " is stronger than an average horse-boy.");
		}

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return StrengthLevel.getStrengthLevelFromValue(target.getAttributeValue(Attribute.STRENGTH)) == StrengthLevel.THREE_POWERFUL;
		}
		
		@Override
		public boolean renderInEffectsPanel() {
			return false;
		}
	},
	STRENGTH_PERK_4(
			100,
			"mighty",
			"attStrength4",
			Colour.STRENGTH_STAGE_FOUR,
			true,
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.DAMAGE_PHYSICAL, 20f),
					new Value<Attribute, Float>(Attribute.CRITICAL_DAMAGE, 20f)),
			null) {
		
		@Override
		public String getName(GameCharacter target) {
			return Util.capitaliseSentence(StrengthLevel.FOUR_MIGHTY.getName());
		}
		
		@Override
		public String getDescription(GameCharacter target) {
			if (target.isPlayer())
				return "Your strength is enough to rival a dragon-morph's, and, when compared to the more common races of Dominion, their strength pales in comparison to yours.";
			else
				return UtilText.genderParsing(target, target.getName("The") + " is as strong as a dragon-morph!");
		}

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return StrengthLevel.getStrengthLevelFromValue(target.getAttributeValue(Attribute.STRENGTH)) == StrengthLevel.FOUR_MIGHTY;
		}
		
		@Override
		public boolean renderInEffectsPanel() {
			return false;
		}
	},
	STRENGTH_PERK_5(
			100,
			"Herculean",
			"attStrength5",
			Colour.STRENGTH_STAGE_FIVE,
			true,
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.DAMAGE_PHYSICAL, 25f),
					new Value<Attribute, Float>(Attribute.CRITICAL_DAMAGE, 25f),
					new Value<Attribute, Float>(Attribute.RESISTANCE_PURE, 10f),
					new Value<Attribute, Float>(Attribute.HEALTH_MAXIMUM, 50f)),
			null) {
		
		@Override
		public String getName(GameCharacter target) {
			return Util.capitaliseSentence(StrengthLevel.FIVE_HERCULEAN.getName());
		}
		
		@Override
		public String getDescription(GameCharacter owner) {
			if (owner.isPlayer())
				return "Your body is the stuff of legend; mere mortals look upon you in fear and awe!";
			else
				return UtilText.genderParsing(owner, owner.getName("The") + "'s body is the stuff of legend.");
		}

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return StrengthLevel.getStrengthLevelFromValue(target.getAttributeValue(Attribute.STRENGTH)) == StrengthLevel.FIVE_HERCULEAN;
		}
		
		@Override
		public boolean renderInEffectsPanel() {
			return false;
		}
	},

	// Intelligence:
	INTELLIGENCE_PERK_0(
			80,
			"airhead",
			"attIntelligence0",
			Colour.INTELLIGENCE_STAGE_ZERO,
			false,
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.DAMAGE_SPELLS, -25f),
					new Value<Attribute, Float>(Attribute.SPELL_COST_MODIFIER, -25f)),
			null) {
		
		@Override
		public String getName(GameCharacter target) {
			return Util.capitaliseSentence(IntelligenceLevel.ZERO_AIRHEAD.getName());
		}
		
		@Override
		public String getDescription(GameCharacter owner) {
			if (owner.isPlayer())
				return "You are a complete airhead. You struggle to perform even the most basic of arithmetic, and would likely lose a battle of wits against a brick wall.";
			else
				return UtilText.genderParsing(owner, owner.getName("The") + " has a blank look on <her> face, and every now and then, <she> lets out a little giggle at nothing.");
		}

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return IntelligenceLevel.getIntelligenceLevelFromValue(target.getAttributeValue(Attribute.INTELLIGENCE)) == IntelligenceLevel.ZERO_AIRHEAD;
		}
		
		@Override
		public boolean renderInEffectsPanel() {
			return false;
		}
	},
	INTELLIGENCE_PERK_1(
			100,
			"average",
			"attIntelligence1",
			Colour.INTELLIGENCE_STAGE_ONE,
			true,
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.DAMAGE_ICE, 5f),
					new Value<Attribute, Float>(Attribute.SPELL_COST_MODIFIER, 5f)),
			null) {
		
		@Override
		public String getName(GameCharacter target) {
			return Util.capitaliseSentence(IntelligenceLevel.ONE_AVERAGE.getName());
		}
		
		@Override
		public String getDescription(GameCharacter target) {
			if (target.isPlayer())
				return "You have an average level of intelligence for a human.";
			else
				return UtilText.genderParsing(target, target.getName("The") + " is about as intelligent as an average human.");
		}

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return IntelligenceLevel.getIntelligenceLevelFromValue(target.getAttributeValue(Attribute.INTELLIGENCE)) == IntelligenceLevel.ONE_AVERAGE;
		}
		
		@Override
		public boolean renderInEffectsPanel() {
			return false;
		}
	},
	INTELLIGENCE_PERK_2(
			100,
			"smart",
			"attIntelligence2",
			Colour.INTELLIGENCE_STAGE_TWO,
			true,
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.DAMAGE_ICE, 10f),
					new Value<Attribute, Float>(Attribute.SPELL_COST_MODIFIER, 10f)),
			null) {
		
		@Override
		public String getName(GameCharacter target) {
			return Util.capitaliseSentence(IntelligenceLevel.TWO_SMART.getName());
		}
		
		@Override
		public String getDescription(GameCharacter target) {
			if (target.isPlayer())
				return "You're pretty smart. Your intelligence is significantly higher than that of an average human's.";
			else
				return UtilText.genderParsing(target, target.getName("The") + " is significantly more intelligent than an average human.");
		}

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return IntelligenceLevel.getIntelligenceLevelFromValue(target.getAttributeValue(Attribute.INTELLIGENCE)) == IntelligenceLevel.TWO_SMART;
		}
		
		@Override
		public boolean renderInEffectsPanel() {
			return false;
		}
	},
	INTELLIGENCE_PERK_3(
			100,
			"brainy",
			"attIntelligence3",
			Colour.INTELLIGENCE_STAGE_THREE,
			true,
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.DAMAGE_ICE, 15f),
					new Value<Attribute, Float>(Attribute.SPELL_COST_MODIFIER, 15f)),
			null) {
		
		@Override
		public String getName(GameCharacter target) {
			return Util.capitaliseSentence(IntelligenceLevel.THREE_BRAINY.getName());
		}
		
		@Override
		public String getDescription(GameCharacter target) {
			if (target.isPlayer())
				return "You are exceptionally clever. A demon or angel has an average intelligence of this sort of level.";
			else
				return UtilText.genderParsing(target, target.getName("The") + " is as intelligent as a regular demon or angel.");
		}

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return IntelligenceLevel.getIntelligenceLevelFromValue(target.getAttributeValue(Attribute.INTELLIGENCE)) == IntelligenceLevel.THREE_BRAINY;
		}
		
		@Override
		public boolean renderInEffectsPanel() {
			return false;
		}
	},
	INTELLIGENCE_PERK_4(
			100,
			"genius",
			"attIntelligence4",
			Colour.INTELLIGENCE_STAGE_FOUR,
			true,
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.DAMAGE_ICE, 20f),
					new Value<Attribute, Float>(Attribute.SPELL_COST_MODIFIER, 20f)),
			null) {
		
		@Override
		public String getName(GameCharacter target) {
			return Util.capitaliseSentence(IntelligenceLevel.FOUR_GENIUS.getName());
		}
		
		@Override
		public String getDescription(GameCharacter target) {
			if (target.isPlayer())
				return "Your intelligence is comparable to a Linin's, or, perhaps more relatably, to the greatest minds in human history.";
			else
				return UtilText.genderParsing(target, target.getName("The") + " is as intelligent as a Lilin.");
		}

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return IntelligenceLevel.getIntelligenceLevelFromValue(target.getAttributeValue(Attribute.INTELLIGENCE)) == IntelligenceLevel.FOUR_GENIUS;
		}
		
		@Override
		public boolean renderInEffectsPanel() {
			return false;
		}
	},
	INTELLIGENCE_PERK_5(
			100,
			"polymath",
			"attIntelligence5",
			Colour.INTELLIGENCE_STAGE_FIVE,
			true,
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.DAMAGE_ICE, 25f),
					new Value<Attribute, Float>(Attribute.SPELL_COST_MODIFIER, 25f),
					new Value<Attribute, Float>(Attribute.DAMAGE_PURE, 5f),
					new Value<Attribute, Float>(Attribute.MANA_MAXIMUM, 50f)),
			null) {
		
		@Override
		public String getName(GameCharacter target) {
			return Util.capitaliseSentence(IntelligenceLevel.FIVE_POLYMATH.getName());
		}
		
		@Override
		public String getDescription(GameCharacter owner) {
			if (owner.isPlayer())
				return "The greatest scientists and philosophers in human history pale in comparison to your mighty intellect.";
			else
				return UtilText.genderParsing(owner, owner.getName("The") + " is one of the most intelligent beings to ever have existed.");
		}

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return IntelligenceLevel.getIntelligenceLevelFromValue(target.getAttributeValue(Attribute.INTELLIGENCE)) == IntelligenceLevel.FIVE_POLYMATH;
		}
		
		@Override
		public boolean renderInEffectsPanel() {
			return false;
		}
	},

	// Agility:
	FITNESS_PERK_0(
			80,
			"clutz",
			"attFitness0",
			Colour.FITNESS_STAGE_ZERO,
			false,
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.CRITICAL_CHANCE, -25f),
					new Value<Attribute, Float>(Attribute.CRITICAL_DAMAGE, -25f)),
			null) {
		
		@Override
		public String getName(GameCharacter target) {
			return Util.capitaliseSentence(FitnessLevel.ZERO_CLUTZ.getName());
		}
		
		@Override
		public String getDescription(GameCharacter owner) {
			if (owner.isPlayer())
				return "You are incredibly clumsy, and sometimes even struggle to place one foot in front of the other.";
			else
				return UtilText.genderParsing(owner, owner.getName("The")
						+ " is extremely clumsy, and constantly trips over <her> own feet.");
		}

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return FitnessLevel.getFitnessLevelFromValue(target.getAttributeValue(Attribute.FITNESS)) == FitnessLevel.ZERO_CLUTZ;
		}
		
		@Override
		public boolean renderInEffectsPanel() {
			return false;
		}
	},
	FITNESS_PERK_1(
			100,
			"average",
			"attFitness1",
			Colour.FITNESS_STAGE_ONE,
			true,
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.DAMAGE_FIRE, 5f),
					new Value<Attribute, Float>(Attribute.CRITICAL_CHANCE, 4f)),
			null) {
		
		@Override
		public String getName(GameCharacter target) {
			return Util.capitaliseSentence(FitnessLevel.ONE_AVERAGE.getName());
		}
		
		@Override
		public String getDescription(GameCharacter target) {
			if (target.isPlayer())
				return "You have an average level of fitness for a human.";
			else
				return UtilText.genderParsing(target, target.getName("The") + " is about as fit as an average human.");
		}

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return FitnessLevel.getFitnessLevelFromValue(target.getAttributeValue(Attribute.FITNESS)) == FitnessLevel.ONE_AVERAGE;
		}
		
		@Override
		public boolean renderInEffectsPanel() {
			return false;
		}
	},
	FITNESS_PERK_2(
			100,
			"flexible",
			"attFitness2",
			Colour.FITNESS_STAGE_TWO,
			true,
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.DAMAGE_FIRE, 10f),
					new Value<Attribute, Float>(Attribute.CRITICAL_CHANCE, 8f)),
			null) {
		
		@Override
		public String getName(GameCharacter target) {
			return Util.capitaliseSentence(FitnessLevel.TWO_FLEXIBLE.getName());
		}
		
		@Override
		public String getDescription(GameCharacter target) {
			if (target.isPlayer())
				return "You are very flexible, and can easily do the splits and cartwheels on demand.";
			else
				return UtilText.genderParsing(target, target.getName("The") + " is very flexible.");
		}

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return FitnessLevel.getFitnessLevelFromValue(target.getAttributeValue(Attribute.FITNESS)) == FitnessLevel.TWO_FLEXIBLE;
		}
		
		@Override
		public boolean renderInEffectsPanel() {
			return false;
		}
	},
	FITNESS_PERK_3(
			100,
			"limber",
			"attFitness3",
			Colour.FITNESS_STAGE_THREE,
			true,
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.DAMAGE_FIRE, 15f),
					new Value<Attribute, Float>(Attribute.CRITICAL_CHANCE, 12f)),
			null) {
		
		@Override
		public String getName(GameCharacter target) {
			return Util.capitaliseSentence(FitnessLevel.THREE_LIMBER.getName());
		}
		
		@Override
		public String getDescription(GameCharacter target) {
			if (target.isPlayer())
				return "You are extremely fit, and can easily contort your body into all sorts of uncomfortable-looking shapes.";
			else
				return UtilText.genderParsing(target, target.getName("The") + " is incredibly fit.");
		}

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return FitnessLevel.getFitnessLevelFromValue(target.getAttributeValue(Attribute.FITNESS)) == FitnessLevel.THREE_LIMBER;
		}
		
		@Override
		public boolean renderInEffectsPanel() {
			return false;
		}
	},
	FITNESS_PERK_4(
			100,
			"athletic",
			"attFitness4",
			Colour.FITNESS_STAGE_FOUR,
			true,
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.DAMAGE_FIRE, 20f),
					new Value<Attribute, Float>(Attribute.CRITICAL_CHANCE, 16f)),
			null) {
		
		@Override
		public String getName(GameCharacter target) {
			return Util.capitaliseSentence(FitnessLevel.FOUR_ATHLETIC.getName());
		}
		
		@Override
		public String getDescription(GameCharacter target) {
			if (target.isPlayer())
				return "You have the same level of fitness as a top-class athlete, and could easily run a full marathon with enough energy left over to do it all over again.";
			else
				return UtilText.genderParsing(target, target.getName("The") + " is exceedingly fit and healthy.");
		}

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return FitnessLevel.getFitnessLevelFromValue(target.getAttributeValue(Attribute.FITNESS)) == FitnessLevel.FOUR_ATHLETIC;
		}
		
		@Override
		public boolean renderInEffectsPanel() {
			return false;
		}
	},
	FITNESS_PERK_5(
			100,
			"acrobat",
			"attFitness5",
			Colour.FITNESS_STAGE_FIVE,
			true,
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.DAMAGE_FIRE, 25f),
					new Value<Attribute, Float>(Attribute.STAMINA_MAXIMUM, 50f),
					new Value<Attribute, Float>(Attribute.DAMAGE_PURE, 5f),
					new Value<Attribute, Float>(Attribute.CRITICAL_CHANCE, 20f)),
			null) {
		
		@Override
		public String getName(GameCharacter target) {
			return Util.capitaliseSentence(FitnessLevel.FIVE_ACROBAT.getName());
		}
		
		@Override
		public String getDescription(GameCharacter owner) {
			if (owner.isPlayer())
				return "You have super-human reflexes and agility, and each of your steps radiate an ethereal grace.";
			else
				return UtilText.genderParsing(owner, owner.getName("The")
						+ " moves with an ethereal grace, making <her> supreme agility apparent in each of <her> delicate steps.");
		}

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return FitnessLevel.getFitnessLevelFromValue(target.getAttributeValue(Attribute.FITNESS)) == FitnessLevel.FIVE_ACROBAT;
		}
		
		@Override
		public boolean renderInEffectsPanel() {
			return false;
		}
	},

	// Corruption:
	CORRUPTION_PERK_0(100,
			"Pure",
			"attCorruption0",
			Colour.CORRUPTION_STAGE_ZERO,
			true,
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.RESISTANCE_MANA, 25f)),
			null) {

		@Override
		public String getName(GameCharacter target) {
			return Util.capitaliseSentence(CorruptionLevel.ZERO_PURE.getName());
		}
		
		@Override
		public String getDescription(GameCharacter owner) {
			if (owner.isPlayer())
				return "Your body and mind are completely untained by corruption. You might consider performing the most conservative of sexual acts with the person you love, but other than that, you're not interested in sex at all.";
			else
				return UtilText.genderParsing(owner, owner.getName("The") + " is completely pure, and strongly resists temptation.");
		}

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return CorruptionLevel.getCorruptionLevelFromValue(target.getAttributeValue(Attribute.CORRUPTION)) == CorruptionLevel.ZERO_PURE;
		}
		
		@Override
		public boolean renderInEffectsPanel() {
			return false;
		}
	},
	CORRUPTION_PERK_1(
			100,
			"Vanilla",
			"attCorruption1",
			Colour.CORRUPTION_STAGE_ONE,
			false,
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.RESISTANCE_MANA, -10f),
					new Value<Attribute, Float>(Attribute.DAMAGE_MANA, 5f),
					new Value<Attribute, Float>(Attribute.DAMAGE_POISON, 5f)),
			null) {

		@Override
		public String getName(GameCharacter target) {
			return Util.capitaliseSentence(CorruptionLevel.ONE_VANILLA.getName());
		}
		
		@Override
		public String getDescription(GameCharacter owner) {
			if (owner.isPlayer())
				return "You're open to the idea of having some pretty vanilla sex (by this world's standards)."
						+ " While you might be happy to turn the tables on anyone who tries to force you into sex, you remind yourself that you're only doing it because they're totally up for it.";
			else
				return UtilText.genderParsing(owner, owner.getName("The") + " has a dirty look in <her> eyes, and you often notice <her> gaze lingering hungrily over your body.");
		}

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return CorruptionLevel.getCorruptionLevelFromValue(target.getAttributeValue(Attribute.CORRUPTION)) == CorruptionLevel.ONE_VANILLA;
		}
		
		@Override
		public boolean renderInEffectsPanel() {
			return false;
		}
	},
	CORRUPTION_PERK_2(
			100,
			"dirty",
			"attCorruption2",
			Colour.CORRUPTION_STAGE_TWO,
			false,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.RESISTANCE_MANA, -20f),
					new Value<Attribute, Float>(Attribute.DAMAGE_MANA, 10f),
					new Value<Attribute, Float>(Attribute.DAMAGE_POISON, 10f)),
			null) {

		@Override
		public String getName(GameCharacter target) {
			return Util.capitaliseSentence(CorruptionLevel.TWO_HORNY.getName());
		}
		
		@Override
		public String getDescription(GameCharacter owner) {
			if (owner.isPlayer())
				return "Your eyes have been opened by this world's casual attitude towards sex. Sexual acts that once may have made you feel uncomfortable are now the focus of your fantasies, and you can't wait to try them out on a willing partner...";
			else
				return UtilText.genderParsing(owner, owner.getName("The") + " has a dirty look in <her> eyes, and you often notice <her> gaze lingering hungrily over your body.");
		}

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return CorruptionLevel.getCorruptionLevelFromValue(target.getAttributeValue(Attribute.CORRUPTION)) == CorruptionLevel.TWO_HORNY;
		}
		
		@Override
		public boolean renderInEffectsPanel() {
			return false;
		}
	},
	CORRUPTION_PERK_3(
			100,
			"Lewd",
			"attCorruption3",
			Colour.CORRUPTION_STAGE_THREE,
			false,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.RESISTANCE_MANA, -30f),
					new Value<Attribute, Float>(Attribute.DAMAGE_MANA, 10f),
					new Value<Attribute, Float>(Attribute.FERTILITY, 25f),
					new Value<Attribute, Float>(Attribute.VIRILITY, 25f),
					new Value<Attribute, Float>(Attribute.DAMAGE_POISON, 15f)),
			null) {

		@Override
		public String getName(GameCharacter target) {
			return Util.capitaliseSentence(CorruptionLevel.THREE_DIRTY.getName());
		}
		
		@Override
		public String getDescription(GameCharacter owner) {
			if (owner.isPlayer()) {
				if (Main.game.getPlayer().getVaginaType() != VaginaType.NONE)
					return "Your body has started to react to some of the fantasies that constantly run through your mind, and you feel as though it's going to be far easier to get pregnant from now on...";
				else if (Main.game.getPlayer().getPenisType() != PenisType.NONE)
					return "Your body has started to react to some of the fantasies that constantly run through your mind, and you feel as though it's going to be far easier to impregnate your sexual partners from now on...";
				else
					return "Your body is trying to react to some of the fantasies that constantly run through your mind, but because you don't have any sexual organs, there's not much that's happened...";
			} else {
				if (owner.getVaginaType() != VaginaType.NONE)
					return UtilText.genderParsing(owner, owner.getName("The") + "'s body is extremely fertile, and <her> thoughts often dwell on being fucked pregnant.");
				else if (owner.getPenisType() != PenisType.NONE)
					return UtilText.genderParsing(owner, owner.getName("The") + "'s body has become extremely fertile, and <her> thoughts often dwell on filling wombs with <her> potent seed.");
				else
					return UtilText.genderParsing(owner,
							owner.getName("The") + "'s body has become extremely fertile, and <she> longs to have sexual organs with which to make use of <her> breeder's body.");
			}
		}

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return CorruptionLevel.getCorruptionLevelFromValue(target.getAttributeValue(Attribute.CORRUPTION)) == CorruptionLevel.THREE_DIRTY;
		}
		
		@Override
		public boolean renderInEffectsPanel() {
			return false;
		}
	},
	CORRUPTION_PERK_4(
			100,
			"Lustful",
			"attCorruption4",
			Colour.CORRUPTION_STAGE_FOUR,
			false,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.RESISTANCE_MANA, -40f),
					new Value<Attribute, Float>(Attribute.DAMAGE_MANA, 10f),
					new Value<Attribute, Float>(Attribute.FERTILITY, 50f),
					new Value<Attribute, Float>(Attribute.VIRILITY, 50f),
					new Value<Attribute, Float>(Attribute.DAMAGE_POISON, 20f)),
			null) {

		@Override
		public String getName(GameCharacter target) {
			return Util.capitaliseSentence(CorruptionLevel.FOUR_LUSTFUL.getName());
		}

		@Override
		public String getDescription(GameCharacter owner) {
			if (owner.isPlayer()) {
				if (Main.game.getPlayer().getVaginaType() != VaginaType.NONE)
					return "Your body is reacting strongly now to some of the fantasies that constantly run through your mind, and you feel as though it's going to be much easier to get pregnant from now on...";
				else if (Main.game.getPlayer().getPenisType() != PenisType.NONE)
					return "Your body is reacting strongly now to some of the fantasies that constantly run through your mind, and you feel as though it's going to be much easier to impregnate your sexual partners from now on...";
				else
					return "Your body is trying to react to some of the fantasies that constantly run through your mind, but because you don't have any sexual organs, there's not much that's happened...";
			} else {
				if (owner.getVaginaType() != VaginaType.NONE)
					return UtilText.genderParsing(owner, owner.getName("The") + "'s body is extremely fertile, and <her> thoughts often dwell on being fucked pregnant.");
				else if (owner.getPenisType() != PenisType.NONE)
					return UtilText.genderParsing(owner, owner.getName("The") + "'s body has become extremely fertile, and <her> thoughts often dwell on filling wombs with <her> potent seed.");
				else
					return UtilText.genderParsing(owner,
							owner.getName("The") + "'s body has become extremely fertile, and <she> longs to have sexual organs with which to make use of <her> breeder's body.");
			}
		}

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return CorruptionLevel.getCorruptionLevelFromValue(target.getAttributeValue(Attribute.CORRUPTION)) == CorruptionLevel.FOUR_LUSTFUL;
		}
		
		@Override
		public boolean renderInEffectsPanel() {
			return false;
		}
	},
	CORRUPTION_PERK_5(
			100,
			"Corrupt",
			"attCorruption5",
			Colour.CORRUPTION_STAGE_FIVE,
			false,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.RESISTANCE_MANA, -50f),
					new Value<Attribute, Float>(Attribute.DAMAGE_MANA, 25f),
					new Value<Attribute, Float>(Attribute.FERTILITY, 75f),
					new Value<Attribute, Float>(Attribute.VIRILITY, 75f),
					new Value<Attribute, Float>(Attribute.DAMAGE_POISON, 25f)),
			Util.newArrayListOfValues(new ListValue<String>("<b style='color: "
					+ Colour.ATTRIBUTE_CORRUPTION.toWebHexString()
					+ "'>Obeys Lilin</b>"))) {

		@Override
		public String getName(GameCharacter target) {
			return Util.capitaliseSentence(CorruptionLevel.FIVE_CORRUPT.getName());
		}
		
		@Override
		public String getDescription(GameCharacter owner) {
			if (owner.isPlayer())
				return "You've been completely and utterly corrupted by the arcane. You're constantly thinking of new ways to fuck people, and you wonder what they'd say if they knew the sort of positions you're imagining them in...";
			else
				return UtilText.genderParsing(owner, owner.getName("The") + " is completely and utterly corrupted.");

		}

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return CorruptionLevel.getCorruptionLevelFromValue(target.getAttributeValue(Attribute.CORRUPTION)) == CorruptionLevel.FIVE_CORRUPT;
		}
		
		@Override
		public boolean renderInEffectsPanel() {
			return false;
		}
	},
	
	// Arousal:
	AROUSAL_PERK_0(
			100,
			"none",
			"attArousal0",
			Colour.AROUSAL_STAGE_ZERO,
			false,
			null,
			null) {
		
		@Override
		public String getName(GameCharacter target) {
			return Util.capitaliseSentence(ArousalLevel.ZERO_NONE.getName());
		}
		
		@Override
		public String getDescription(GameCharacter target) {
			if (target.isPlayer())
				return "You aren't aroused at all.";
			else
				return UtilText.genderParsing(target, target.getName("The") + " isn't aroused at all.");
		}

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return ArousalLevel.getArousalLevelFromValue(target.getAttributeValue(Attribute.AROUSAL)) == ArousalLevel.ZERO_NONE;
		}
		
		@Override
		public boolean renderInEffectsPanel() {
			return false;
		}
	},
	AROUSAL_PERK_1(
			100,
			"turned on",
			"attArousal1",
			Colour.AROUSAL_STAGE_ONE,
			false,
			null,
			null) {
		
		@Override
		public String getName(GameCharacter target) {
			return Util.capitaliseSentence(ArousalLevel.ONE_TURNED_ON.getName());
		}
		
		@Override
		public String getDescription(GameCharacter target) {
			if (target.isPlayer())
				return "You're starting to get pretty turned on.";
			else
				return UtilText.genderParsing(target, target.getName("The") + " is starting to get turned on.");
		}

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return ArousalLevel.getArousalLevelFromValue(target.getAttributeValue(Attribute.AROUSAL)) == ArousalLevel.ONE_TURNED_ON;
		}
		
		@Override
		public boolean renderInEffectsPanel() {
			return false;
		}
	},
	AROUSAL_PERK_2(
			100,
			"excited",
			"attArousal2",
			Colour.AROUSAL_STAGE_TWO,
			false,
			null,
			null) {
		
		@Override
		public String getName(GameCharacter target) {
			return Util.capitaliseSentence(ArousalLevel.TWO_EXCITED.getName());
		}
		
		@Override
		public String getDescription(GameCharacter target) {
			if (target.isPlayer())
				return "You're getting quite excited, and your thoughts are now focused on your sexual desires.";
			else
				return UtilText.genderParsing(target, target.getName("The") + " is getting quite excited.");
		}

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return ArousalLevel.getArousalLevelFromValue(target.getAttributeValue(Attribute.AROUSAL)) == ArousalLevel.TWO_EXCITED;
		}
		
		@Override
		public boolean renderInEffectsPanel() {
			return false;
		}
	},
	AROUSAL_PERK_3(
			100,
			"heated",
			"attArousal3",
			Colour.AROUSAL_STAGE_THREE,
			false,
			null,
			null) {
		
		@Override
		public String getName(GameCharacter target) {
			return Util.capitaliseSentence(ArousalLevel.THREE_HEATED.getName());
		}
		
		@Override
		public String getDescription(GameCharacter target) {
			if (target.isPlayer())
				return "Things are starting to get pretty heated. You can focus on nothing but the thought of sex.";
			else
				return UtilText.genderParsing(target, target.getName("The") + " can no longer focus on anything but sex.");
		}

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return ArousalLevel.getArousalLevelFromValue(target.getAttributeValue(Attribute.AROUSAL)) == ArousalLevel.THREE_HEATED;
		}
		
		@Override
		public boolean renderInEffectsPanel() {
			return false;
		}
	},
	AROUSAL_PERK_4(
			100,
			"passionate",
			"attArousal4",
			Colour.AROUSAL_STAGE_FOUR,
			false,
			null,
			Util.newArrayListOfValues(
					new ListValue<String>("<b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>Mutual orgasm</b>"))) {
		
		@Override
		public String getName(GameCharacter target) {
			return Util.capitaliseSentence(ArousalLevel.FOUR_PASSIONATE.getName());
		}
		
		@Override
		public String getDescription(GameCharacter target) {
			if (target.isPlayer())
				return "The only thing you want right now is to reach your climax.";
			else
				return UtilText.genderParsing(target, target.getName("The") + " is only concerned with reaching <her> climax.");
		}

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return ArousalLevel.getArousalLevelFromValue(target.getAttributeValue(Attribute.AROUSAL)) == ArousalLevel.FOUR_PASSIONATE;
		}
		
		@Override
		public boolean renderInEffectsPanel() {
			return false;
		}
	},
	AROUSAL_PERK_5(
			100,
			"imminent orgasm",
			"attArousal5",
			Colour.AROUSAL_STAGE_FIVE,
			false,
			null,
			Util.newArrayListOfValues(
					new ListValue<String>("<b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>Mutual orgasm</b>"))) {
		
		@Override
		public String getName(GameCharacter target) {
			return Util.capitaliseSentence(ArousalLevel.FIVE_ORGASM_IMMINENT.getName());
		}
		
		@Override
		public String getDescription(GameCharacter owner) {
			if (owner.isPlayer())
				return "You feel your climax building. You know that it's only going to be a matter of seconds before you orgasm!";
			else
				return UtilText.genderParsing(owner, owner.getName("The") + " is about to reach <her> climax!");
		}

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return ArousalLevel.getArousalLevelFromValue(target.getAttributeValue(Attribute.AROUSAL)) == ArousalLevel.FIVE_ORGASM_IMMINENT;
		}
		
		@Override
		public boolean renderInEffectsPanel() {
			return false;
		}
	},
	
	
	
	// STANDARD EFFECTS:

	WEATHER_CLEAR(100,
			"Clear skies",
			"weatherDayClear",
			Colour.CLOTHING_WHITE,
			false,
			null,
			Util.newArrayListOfValues(new ListValue<String>("<b style='color: " + Colour.GENERIC_ARCANE.toWebHexString() + ";'>Enhanced libido</b>"))) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			if(Main.game.isDayTime())
				return "A hot summer's sun shines down on you, and you let out a contented sigh as you look up at the clear blue sky."
						+ " Although there's no sign of a storm at the moment, you can still feel the effects of the arcane manifesting in the form of an increased libido.";
			else
				return "The moon shines down through a clear night's sky, and you let out a contented sigh as you look up at the stars."
						+ " Although there's no sign of a storm at the moment, you can still feel the effects of the arcane manifesting in the form of an increased libido.";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return Main.game.getCurrentWeather()==Weather.CLEAR;
		}
		
		@Override
		public String getSVGString(GameCharacter owner) {
			if(Main.game.isDayTime())
				return SVGImages.SVG_IMAGE_PROVIDER.getWeatherDayClear();
			else
				return SVGImages.SVG_IMAGE_PROVIDER.getWeatherNightClear();
		}
	},
	WEATHER_CLOUD(100,
			"Cloudy skies",
			"weatherDayCloudy",
			Colour.CLOTHING_WHITE,
			false,
			null,
			Util.newArrayListOfValues(new ListValue<String>("<b style='color: " + Colour.GENERIC_ARCANE.toWebHexString() + ";'>Enhanced libido</b>"))) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			return "The weather seems to change at a moment's notice, and is currently overcast, with a chance of rain."
					+ " Although there's no sign of a storm at the moment, you can still feel the effects of the arcane manifesting in the form of an increased libido";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return Main.game.getCurrentWeather()==Weather.CLOUD;
		}
		
		@Override
		public String getSVGString(GameCharacter owner) {
			if(Main.game.isDayTime())
				return SVGImages.SVG_IMAGE_PROVIDER.getWeatherDayCloud();
			else
				return SVGImages.SVG_IMAGE_PROVIDER.getWeatherNightCloud();
		}
	},
	WEATHER_RAIN(100,
			"Rain",
			"weatherDayRain",
			Colour.CLOTHING_WHITE,
			false,
			null,
			Util.newArrayListOfValues(new ListValue<String>("<b style='color: " + Colour.GENERIC_ARCANE.toWebHexString() + ";'>Enhanced libido</b>"))) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			if(Main.game.isDayTime())
				return "The sudden downpour is a welcome relief from the hot summer sun."
						+ " Although there's no sign of a storm at the moment, you can still feel the effects of the arcane manifesting in the form of an increased libido";
			else
				return "The heavy rain clouds overhead have finally burst, and you find yourself out in the middle of a sudden downpour."
						+ " Although there's no sign of an arcane storm at the moment, you can still feel its effects manifesting in the form of an increased libido";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return Main.game.getCurrentWeather()==Weather.RAIN;
		}
		
		@Override
		public String getSVGString(GameCharacter owner) {
			if(Main.game.isDayTime())
				return SVGImages.SVG_IMAGE_PROVIDER.getWeatherDayRain();
			else
				return SVGImages.SVG_IMAGE_PROVIDER.getWeatherNightRain();
		}
	},
	WEATHER_STORM_GATHERING(100,
			"Gathering storm",
			"weatherDayStormIncoming",
			Colour.CLOTHING_WHITE,
			false,
			null,
			Util.newArrayListOfValues(new ListValue<String>("<b style='color: " + Colour.GENERIC_ARCANE.toWebHexString() + ";'>Enhanced libido</b>"))) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			return "A roiling mass of thick black storm clouds hang heavy in the skies above you."
					+ " Flashes of pink and purple energy can be seen just beneath their surface, and you realise that an arcane storm is going to break out at any moment.";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return Main.game.getCurrentWeather()==Weather.MAGIC_STORM_GATHERING;
		}
		
		@Override
		public String getSVGString(GameCharacter owner) {
			if(Main.game.isDayTime())
				return SVGImages.SVG_IMAGE_PROVIDER.getWeatherDayStormIncoming();
			else
				return SVGImages.SVG_IMAGE_PROVIDER.getWeatherNightStormIncoming();
		}
	},
	WEATHER_STORM(100,
			"Arcane storm",
			"weatherDayStorm",
			Colour.CLOTHING_WHITE,
			false,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.RESISTANCE_MANA, -15f)),
			Util.newArrayListOfValues(new ListValue<String>("<b style='color: "
					+ Colour.GENERIC_ARCANE.toWebHexString()
					+ ";'>Enhanced libido</b>"))) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			if(target.isPlayer() && Main.game.getDialogueFlags().stormTextUpdate) {
				Main.game.getDialogueFlags().stormTextUpdate = false;
				return "<p>"
						+ "A bright-pink flash suddenly illuminates the entire city of Dominion, causing those few residents still prowling the streets to look skywards."
						+ " High up above them, the threatening storm clouds have finally broken, and a roiling mass of arcane energy finally crackles into life."
						+ "</p>"
						+ "<p>"
						+ "Within moments, a ghostly series of lewd moans and ecstatic screams start echoing throughout the city, and as the arcane thunder penetrates into the minds of those without a strong aura,"
						+ " they find themselves unable to think of anything but sex..."
						+ "</p>";
			} else {
				return "";
			}
		}

		@Override
		public String getDescription(GameCharacter target) {
			if (target.isPlayer()) {
				return "Huge streaks of pink and purple lightning arc through the sky as an arcane storm rages high above you."
						+ " Although resistant to most of its arousing power, you're not completely unaffected, and you find yourself feeling hornier than usual.";
			} else {
				return UtilText.genderParsing(target, target.getName("The")
						+ " seems to be just as resistant to the ongoing arcane storm as you are!");
			}
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			if(!target.getRace().isVulnerableToLilithsLustStorm() && !target.getLocationPlace().isStormImmune()) {
				return Main.game.getCurrentWeather()==Weather.MAGIC_STORM;
			} else {
				return false;
			}
		}
		
		@Override
		public String getSVGString(GameCharacter owner) {
			if(Main.game.isDayTime())
				return SVGImages.SVG_IMAGE_PROVIDER.getWeatherDayStorm();
			else
				return SVGImages.SVG_IMAGE_PROVIDER.getWeatherNightStorm();
		}
	},
	WEATHER_STORM_VULNERABLE(100,
			"Arcane storm",
			"weatherDayStorm",
			Colour.CLOTHING_WHITE,
			false,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.RESISTANCE_MANA, -75f)),
			Util.newArrayListOfValues(new ListValue<String>("<b style='color: "
					+ Colour.GENERIC_ARCANE.toWebHexString()
					+ ";'>Enhanced libido</b>"),
					new ListValue<String>("<b style='color: "
							+ Colour.GENERIC_ARCANE.toWebHexString()
							+ ";'>Overwhelming Lust</b>"))) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			return UtilText.genderParsing(target, target.getName("The") + " is being heavily affected by the ongoing arcane storm.");
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			if(target.getRace().isVulnerableToLilithsLustStorm() && !target.getLocationPlace().isStormImmune()) {
				return Main.game.getCurrentWeather()==Weather.MAGIC_STORM;
			} else {
				return false;
			}
		}
		
		@Override
		public String getSVGString(GameCharacter owner) {
			if(Main.game.isDayTime())
				return SVGImages.SVG_IMAGE_PROVIDER.getWeatherDayStorm();
			else
				return SVGImages.SVG_IMAGE_PROVIDER.getWeatherNightStorm();
		}
	},
	WEATHER_STORM_PROTECTED(100,
			"Arcane storm (protected)",
			"weatherDayStorm",
			Colour.GENERIC_GOOD,
			false,
			null,
			Util.newArrayListOfValues(new ListValue<String>("<b style='color: "
					+ Colour.GENERIC_ARCANE.toWebHexString()
					+ ";'>Enhanced libido</b>"))) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			if(target.isPlayer() && Main.game.getDialogueFlags().stormTextUpdate) {
				Main.game.getDialogueFlags().stormTextUpdate = false;
				return "<p>"
						+ "A bright-pink flash suddenly illuminates the entire city of Dominion, causing those few residents still prowling the streets to look skywards."
						+ " High up above them, the threatening storm clouds have finally broken, and a roiling mass of arcane energy finally crackles into life."
						+ "</p>"
						+ "<p>"
						+ "Within moments, a ghostly series of lewd moans and ecstatic screams start echoing throughout the city, and as the arcane thunder penetrates into the minds of those without a strong aura,"
						+ " they find themselves unable to think of anything but sex..."
						+ "</p>";
			} else {
				return "";
			}
		}

		@Override
		public String getDescription(GameCharacter target) {
			if (target.isPlayer()) {
				return "Huge streaks of pink and purple lightning arc through the sky as an arcane storm rages high above you."
						+ " Although you can still feel its effects taking the form of an increased libido, you're currently protected from most of the storm's wrath.";
			} else {
				return UtilText.parse(target,
						"[npc.Name] is currently protected from the arcane storm.");
			}
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			if(target.getLocationPlace().isStormImmune()) {
				return Main.game.getCurrentWeather()==Weather.MAGIC_STORM;
			} else {
				return false;
			}
		}
		
		@Override
		public String getSVGString(GameCharacter owner) {
			if(Main.game.isDayTime())
				return SVGImages.SVG_IMAGE_PROVIDER.getWeatherDayStormProtected();
			else
				return SVGImages.SVG_IMAGE_PROVIDER.getWeatherNightStormProtected();
		}
	},
	
	
	// RACES:
	// HUMAN:
	PURE_HUMAN(
			90,
			"human",
			"raceHuman",
			Colour.CLOTHING_WHITE,
			true,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.RESISTANCE_MANA, 10f)),
			null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			return "Humans are more easily able to resist corruption.";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return target.getRace() == Race.HUMAN
					&& target.getRaceStage() == RaceStage.HUMAN;
		}
	},

	// ANGEL:
	ANGEL(
			90,
			"angel",
			"raceHuman",
			Colour.CLOTHING_WHITE,
			true,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.RESISTANCE_MANA, 100f)),
			null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			return "Angels are completely immune to corruption.";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return target.getRace() == Race.ANGEL
					&& target.getRaceStage() == RaceStage.GREATER;
		}
	},

	// DEMON: TODO
	DEMON(
			90,
			"demon",
			"raceDemon",
			Colour.GENERIC_ARCANE,
			true,
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.CORRUPTION, 25f),
					new Value<Attribute, Float>(Attribute.FITNESS, 10f),
					new Value<Attribute, Float>(Attribute.INTELLIGENCE, 10f),
					new Value<Attribute, Float>(Attribute.DAMAGE_MANA, 10f),
					new Value<Attribute, Float>(Attribute.DAMAGE_SPELLS, 75f)),
			null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			if (target.isPlayer())
				return "You have been twisted by arcane corruption into becoming a demon!"
						+ " (You hear a little voice in your head saying: 'Demon transformations don't actually work like this in the lore! This is just to have some fun until I implement proper TF mechanics!')";
			else
				return UtilText.genderParsing(target,
						"Due to the fact that demons are very easily able to harness arcane power, "+target.getName("this")+"'s spell-casting abilities are truly a terrifying force to behold!");
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return target.getRace() == Race.DEMON
					&& target.getRaceStage() == RaceStage.GREATER;
		}
	},

	// CANINE:
	DOG_MORPH(
			90,
			"dog-morph",
			"raceDogMorph",
			Colour.RACE_DOG_MORPH,
			true,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.FITNESS, 5f), new Value<Attribute, Float>(Attribute.STRENGTH, 5f)),
			null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			if (target.isPlayer())
				return "You always have lots of energy, and get excited about new things very easily.";
			else
				return UtilText.genderParsing(target, target.getName("The")
						+ " always has lots of energy, and <she> gets excited about new things very easily.");
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return target.getRace() == Race.DOG_MORPH
					&& target.getRaceStage() == RaceStage.GREATER;
		}
	},
	WOLF_MORPH(
			90,
			"wolf-morph",
			"raceDogMorph",
			Colour.RACE_WOLF_MORPH,
			true,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.CORRUPTION, 5f), new Value<Attribute, Float>(Attribute.FITNESS, 5f), new Value<Attribute, Float>(Attribute.STRENGTH, 10f)),
			null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			if (target.isPlayer())
				return "Your wolf-like body is very strong, but you often get strong urges to try and dominate people you meet.";
			else
				return UtilText.genderParsing(target, target.getName("The")
						+ "'s wolf-like body is very strong, but <she> often gets strong urges to try and dominate people <she> meets.");
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return target.getRace() == Race.WOLF_MORPH
					&& target.getRaceStage() == RaceStage.GREATER;
		}
	},

	// FELINE:
	CAT_MORPH(
			90,
			"cat-morph",
			"raceCatMorph",
			Colour.RACE_CAT_MORPH,
			true,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.FITNESS, 5f)),
			null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			if (target.isPlayer())
				return "Your body is incredibly agile, and you possess lightning reflexes.";
			else
				return UtilText.genderParsing(target, target.getName("The")
						+ "'s body is incredibly agile, and <she> possesses lightning reflexes.");
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return target.getRace() == Race.CAT_MORPH
					&& target.getRaceStage() == RaceStage.GREATER;
		}
	},

	// EQUINE:
	HORSE_MORPH(
			90,
			"horse-morph",
			"raceHorseMorph",
			Colour.RACE_HORSE_MORPH,
			true,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.INTELLIGENCE, -5f), new Value<Attribute, Float>(Attribute.STRENGTH, 15f)),
			null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			if (target.isPlayer())
				return "Your body possesses a great strength, but your mind is considerably slower than it once was.";
			else
				return UtilText.genderParsing(target, target.getName("The")
						+ "'s body possesses a great strength, but <her> mind isn't exactly the quickest.");
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return target.getRace() == Race.HORSE_MORPH
					&& target.getRaceStage() == RaceStage.GREATER;
		}
	},

	// SLIME:
	SLIME(
			90,
			"slime",
			"raceSlime",
			Colour.CLOTHING_BLUE_LIGHT,
			true,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.RESISTANCE_PHYSICAL, 100f),
					new Value<Attribute, Float>(Attribute.DAMAGE_PHYSICAL, -100f),
					new Value<Attribute, Float>(Attribute.DAMAGE_MANA, 15f),
					new Value<Attribute, Float>(Attribute.RESISTANCE_MANA, -15f)),
			Util.newArrayListOfValues(new ListValue<String>("<b>*</b> <b style='color: "
					+ Colour.CLOTHING_PINK.toWebHexString()
					+ ";'>You can morph your body at will.<b>"))) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			return "Slimes are completely immune to physical damage, but can't really do any physical damage either."
					+ " They can morph their bodies to seem extremely attractive, but also get aroused incredibly easily.";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return target.getRace() == Race.SLIME
					&& target.getRaceStage() == RaceStage.GREATER;
		}
	},

	// AVIAN:
	HARPY(
			90,
			"harpy",
			"raceHarpy",
			Colour.CLOTHING_PINK_LIGHT,
			true,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.DAMAGE_MANA, 10f), new Value<Attribute, Float>(Attribute.STRENGTH, -10f)),
			null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			return "You are a harpy, and are extremely proficient at seduction, although you are quite physically weak.";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return target.getRace() == Race.HARPY
					&& target.getRaceStage() == RaceStage.GREATER;
		}
	},
	
	
	// SEXUAL ORIENTATIONS:
	
	ORIENTATION_ANDROPHILIC(
			90,
			"androphilic",
			"orientation_androphilic",
			Colour.MASCULINE,
			true,
			null,
			Util.newArrayListOfValues(
					new ListValue<String>(
							"<b>-50%</b> <b style='color:"+ Colour.DAMAGE_TYPE_MANA.toWebHexString()+ ";'>Willpower damage</b> from <b style='color:"+ Colour.FEMININE.toWebHexString()+ ";'>feminine opponents</b>"))) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			if(target.isPlayer()) {
				return "You are sexually attracted to males and masculinity.";
			} else {
				return UtilText.parse("[npc.Name] is sexually attracted to males and masculinity.");
			}
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return target.getSexualOrientation()==SexualOrientation.ANDROPHILIC && !target.isPlayer();
		}
		
		@Override
		public boolean isSexEffect() {
			return true;
		}
	},
	ORIENTATION_GYNEPHILIC(
			90,
			"gynephilic",
			"orientation_gynephilic",
			Colour.FEMININE,
			true,
			null,
			Util.newArrayListOfValues(
					new ListValue<String>(
							"<b>-50%</b> <b style='color:"+ Colour.DAMAGE_TYPE_MANA.toWebHexString()+ ";'>Willpower damage</b> from <b style='color:"+ Colour.MASCULINE.toWebHexString()+ ";'>masculine opponents</b>"))) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			if(target.isPlayer()) {
				return "You are sexually attracted to females and femininity.";
			} else {
				return UtilText.parse("[npc.Name] is sexually attracted to females and femininity.");
			}
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return target.getSexualOrientation()==SexualOrientation.GYNEPHILIC && !target.isPlayer();
		}
		
		@Override
		public boolean isSexEffect() {
			return true;
		}
	},
	ORIENTATION_AMBIPHILIC(
			90,
			"ambiphilic",
			"orientation_ambiphilic",
			Colour.ANDROGYNOUS,
			true,
			null,
			null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			if(target.isPlayer()) {
				return "You are sexually attracted to both masculine and feminine people.";
			} else {
				return UtilText.parse("[npc.Name] is sexually attracted to both masculine and feminine people.");
			}
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return target.getSexualOrientation()==SexualOrientation.AMBIPHILIC && !target.isPlayer();
		}
		
		@Override
		public boolean isSexEffect() {
			return true;
		}
	},
	

	// CLOTHING:

	CLOTHING_FEMININITY(
			85,
			"clothing too feminine",
			"clothingFemininity",
			Colour.CLOTHING_PINK_LIGHT,
			false,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.INTELLIGENCE, -5f)),
			null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			return "Some of your clothes are too feminine for your masculine figure."
					+ " You find yourself incredibly embarrassed by wearing such clothing, causing you to struggle to think clearly.";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			if(target.hasFetish(Fetish.FETISH_CROSS_DRESSER)) {
				return false;
			}
			
			for (AbstractClothing c : target.getClothingCurrentlyEquipped()) {
				if (c.getClothingType().getFemininityMinimum() > target.getFemininity()) {
					return true;
				}
			}
			
			return false;
		}
	},
	CLOTHING_MASCULINITY(
			85,
			"clothing too masculine",
			"clothingMasculinity",
			Colour.CLOTHING_BLUE,
			false,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.INTELLIGENCE, -5f)),
			null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			return "Some of your clothes are too masculine for your feminine figure."
					+ " You find yourself incredibly embarrassed by wearing such clothing, causing you to struggle to think clearly.";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			if(target.hasFetish(Fetish.FETISH_CROSS_DRESSER)) {
				return false;
			}
			
			for (AbstractClothing c : target.getClothingCurrentlyEquipped()) {
				if (c.getClothingType().getFemininityMaximum() < target.getFemininity()) {
					return true;
				}
			}
			
			return false;
		}
	},
	CLOTHING_CUM(
			80,
			"dirty clothing",
			"clothingCummedIn",
			Colour.CLOTHING_WHITE,
			false,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.INTELLIGENCE, -2f)),
			null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			// NPCs randomly clean themselves:
			if(!target.isPlayer()) {
				if(Math.random()<minutesPassed*0.05f)
				for (AbstractClothing c : target.getClothingCurrentlyEquipped())
					c.setDirty(false);
			}
			
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			if(target.isPlayer())
				return "Some of your clothes have been covered in cum, milk or other sexual fluids."
						+ " You find yourself incredibly embarrassed to be walking around in such filthy clothing.";
			else
				return "Some of "+target.getName("the")+"'s clothes have been covered in cum, milk or other sexual fluids.";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			for (AbstractClothing c : target.getClothingCurrentlyEquipped())
				if (c.isDirty())
					return true;

			return false;
		}
	},
	CLOTHING_JINXED(
			80,
			"jinxed clothing",
			"arcaneDrain",
			Colour.ATTRIBUTE_CORRUPTION,
			false,
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.STRENGTH, -2f),
					new Value<Attribute, Float>(Attribute.INTELLIGENCE, -2f),
					new Value<Attribute, Float>(Attribute.FITNESS, -2f)),
			null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			if(!Main.game.getDialogueFlags().jinxedClothingDiscovered) {
				Main.game.getDialogueFlags().jinxedClothingDiscovered = true;
				AbstractClothing clothing = null;
				for(AbstractClothing c : target.getClothingCurrentlyEquipped()) {
					if(c.isSealed()) {
						clothing = c;
						break;
					}
				}
				return "<p>"
							+ "As you finish fitting the "+clothing.getName()+" in place, you start to feel a strange warmth radiating from "+(clothing.getClothingType().isPlural()?"their":"its")+" surface."
							+ " Feeling a little uneasy about the manner of arcane enchantment that "+(clothing.getClothingType().isPlural()?"they":"it")+" must contain, you immediately try to take "
								+(clothing.getClothingType().isPlural()?"they":"it")+" off."
						+ "</p>"
						+ "<p>"
							+ "Taking hold of the "+clothing.getName()+", nothing seems to be wrong at first, but as you try to pull "+(clothing.getClothingType().isPlural()?"they":"it")+" off, you find out that you've made a big mistake."
							+ " A jolt of arcane energy suddenly flashes up through your body, and as the invasive force shoots its way into your mind, you find yourself unwittingly releasing your grip."
						+ "</p>"
						+ "<p>"
							+ "Gritting your teeth, you try once again to remove the offending article of clothing, only to find yourself instantly letting go as you try to pull it off "
								+(clothing.getClothingType().isPlural()?"they":"it")+" off."
							+ " No matter how much you struggle, all you're able to do is move the "+clothing.getName()
							+" around a little, and whenever it looks to be in danger of being removed, it moves back into its proper position with a mind of its own."
						+ "</p>"
						+ "<p>"
							+ "Eventually giving up, you decide to go and ask Lilaya what's going on with "+(clothing.getClothingType().isPlural()?"these":"this")
								+" <b style='color:"+Colour.RARITY_JINXED.toWebHexString()+";'>jinxed</b> "+clothing.getName()+"."
							+ " Maybe she'll know a way to break the seal?"
						+ "</p>";
			} else
				return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			return "The enchantment on your jinxed clothing seems to be vampyric in nature. You can feel it draining a little of your arcane aura as it uses your strength to power itself.";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			for(AbstractClothing c : target.getClothingCurrentlyEquipped()) {
				if(c.isSealed()) {
					return true;
				}
			}
			return false;
		}
	},
	
	// OTHER:

	WELL_RESTED(
			80,
			"well rested",
			"wellRested",
			Colour.CLOTHING_BLUE,
			true,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.STAMINA_MAXIMUM, 20f), new Value<Attribute, Float>(Attribute.MANA_MAXIMUM, 20f)),
			null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			return "After having a good rest, you feel full of energy.";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return false;
		}
	},

	PREGNANT_0(
			80,
			"risk of pregnancy",
			"pregnancy0",
			Colour.GENERIC_ARCANE,
			true,
			null,
			null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			if(target.isPlayer())
				return "After recently having unprotected sex, there's a risk that you'll get pregnant!"
					+ " Due to the fact that the arcane accelerates people's pregnancies, you'll know if you're pregnant within a matter of hours.";
			else
				return UtilText.genderParsing(target,
						"After recently having unprotected sex, there's a risk that "+target.getName("the")+" will get pregnant!"
							+ " Due to the fact that the arcane accelerates people's pregnancies, <she>'ll know if <she>'s pregnant within a matter of hours.");
				
		}

		@Override
		public String extraRemovalEffects(GameCharacter target) {
			
			if (target.isPregnant()) {
				target.addStatusEffect(PREGNANT_1, 60 * (72 + Util.random.nextInt(13)));
				
				if (!Main.game.getPlayer().isSideQuestCompleted(QuestLine.SIDE_FIRST_TIME_PREGNANCY)) {
					if(Main.game.getPlayer().hasFetish(Fetish.FETISH_PREGNANCY)) {
						return "<p>"
								+ "For the last few hours, your belly has been gradually swelling."
								+ " The progress was so slow that you didn't even realise anything was happening, but as you glance down at your stomach, there's no mistaking it."
								+ " You're pregnant."
								+ " You experimentally start stroking your abdomen, making soft little gasps as the realisation of what's happening starts to sink in."
							+ "</p>"
							+ "<p>"
								+ "[pc.thought(I-I'm pregnant?"
									+ "</br>"
									+ "..."
									+ "</br>"
									+ "Oh my God! Yes! <b>I'm pregnant!</b>)]"
							+ "</p>"
							+ "<p>"
								+ "The overwhelming happiness you feel at not only discovering that you're pregnant, but also that you're showing physical signs after only a few hours, washes over you like a crashing wave of pure ecstasy."
								+ " You feel tears of joy welling up in your eyes as you lovingly cradle your swollen belly."
							+ "</p>"
							+ "<p>"
								+ "[pc.thought(This is the best feeling ever!"
										+ "</br>"
										+ "If only aunt Lily were here, I bet she'd be so proud!"
										+ "</br>"
										+ "Wait! Of course! <b>Lilaya!</b> She'll want to see this too!)]"
							+ "</p>"
							+ "<p>"
								+ "After a little while of stroking and rubbing your wonderfully-swollen abdomen, you start to calm down a little."
								+ " You decide that you should probably go and see Lilaya, so that she can help you figure out all the details of giving birth."
							+ "</p>"
							+ "<p style='text-align:center;'>"
								+ "<b style='color:"+ Colour.GENERIC_SEX.toWebHexString() + ";'>You're pregnant!</b>"
							+ "</p>";
						
					} else {
						return "<p>"
									+ "For the last few hours, your belly has been gradually swelling."
									+ " The progress was so slow that you didn't even realise anything was happening, but as you glance down at your stomach, there's no mistaking it."
									+ " You're pregnant."
									+ " You experimentally start stroking your abdomen, making soft little gasps as the realisation of what's happening starts to sink in."
								+ "</p>"
								+ "<p>"
									+ "[pc.thought(I-I'm pregnant?"
										+ "</br>"
										+ "..."
										+ "</br>"
										+ "Oh my God! <b>I'm pregnant!</b>)]"
								+ "</p>"
								+ "<p>"
									+ "The sudden shock of not only discovering that you're pregnant, but also that you're showing physical signs after only a few hours, hits you like a sledgehammer."
									+ " Despite your best efforts, you feel yourself starting to hyperventilate as you walk around in little circles, alternating between cradling your head and stomach."
								+ "</p>"
								+ "<p>"
									+ "[pc.thought(What do I do? What do I do? What do I do?"
											+ "</br>"
											+ "If only aunt Lily were here!"
											+ "</br>"
											+ "Wait! Of course! <b>Lilaya!</b> She'll know what to do!)]"
								+ "</p>"
								+ "<p>"
									+ "You start to calm down a little as the initial shock starts to wear off."
									+ " If anyone knows what to do, it'll be Lilaya."
								+ "</p>"
								+ "<p style='text-align:center;'>"
									+ "<b style='color:"+ Colour.GENERIC_SEX.toWebHexString() + ";'>You're pregnant!</b>"
								+ "</p>";
					}
					
				} else {
					return "<p>"
							+ "For the last couple of hours, your belly has been gradually swelling."
							+ " The progress was so slow that you didn't even realise anything was happening, but as you glance down at your stomach, there's no mistaking it."
							+ " You're pregnant again."
							+ " You start stroking your abdomen, making soft little gasps as the familiar feeling of being knocked up returns to you."
						+ "</p>"
						+ "<p>"
							+ (Main.game.getPlayer().hasFetish(Fetish.FETISH_PREGNANCY)
									?"[pc.thought(Haha! Yes! I got pregnant again! This is the best feeling ever...)]"
									:"[pc.thought(Mmm... Looks like I got pregnant again...)]")
						+ "</p>"
						+ "<p>"
							+ (Main.game.getPlayer().hasFetish(Fetish.FETISH_PREGNANCY)
								?"Knowing what you're in for, you let out a delighted laugh before carrying on your way."
								:"Knowing what you're in for, you let out a little contented sigh and start carrying on your way.")
						+ "</p>"
						+ "<p style='text-align:center;'>"
							+ "<b style='color:" + Colour.GENERIC_SEX.toWebHexString()+ ";'>You're pregnant!</b>"
						+ "</p>";
				}
				
			}else{
				target.endPregnancy(false);
				return "<p>"
							+ "Enough time has passed now for you to be sure that you're in the clear."
							+ " There's no sign of any bump in your belly, and you realise that despite having unprotected sex, you managed to avoid getting pregnant."
						+ "</p>"
						+ "<p>"
							+ (Main.game.getPlayer().hasFetish(Fetish.FETISH_PREGNANCY)
								?"[pc.thought(Damn it...)]"
								:"[pc.thought(Well, that's a relief...)]")
						+ "</p>"
						+ "<p style='text-align:center;'>"
							+ "<b style='color:" + Colour.GENERIC_SEX.toWebHexString() + ";'>You aren't pregnant!</b>"
						+ "</p>";	
			}
			
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return false;
		}
		
		@Override
		public boolean isSexEffect() {
			return true;
		}
	},
	PREGNANT_1(
			80,
			"pregnant",
			"pregnancy1",
			Colour.GENERIC_ARCANE,
			true,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.RESISTANCE_PURE, 5f)),
			null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			if(target.isPlayer())
				return "From one of your recent sexual encounters, you've been impregnated!"
						+ " Due to the fact that the arcane accelerates people's pregnancies, you'll move onto the next stage in a matter of days.";
			else
				return UtilText.parse(target,
							"From one of [npc.name]'s recent sexual encounters, [npc.she]'s been impregnated!");
		}

		@Override
		public String extraRemovalEffects(GameCharacter target) {

			target.addStatusEffect(PREGNANT_2, 60 * (72 + Util.random.nextInt(13)));

			if (!Main.game.getPlayer().isSideQuestCompleted(QuestLine.SIDE_FIRST_TIME_PREGNANCY)) {
				return "<p>"
							+ "Even though the change has been gradual, you're suddenly hit by the realisation that your belly has swollen massively."
							+ " You can't resist rubbing your hands over the bump in your abdomen, and you wonder just how big it's going to get."
							+ " As this is your first time getting pregnant, you're not quite sure what to expect, but you're reassured as you remember that Lilaya's always there to help."
						+ "</p>"
						+ "<p style='text-align:center;'>"
							+ "<b style='color:" + Colour.GENERIC_SEX.toWebHexString() + ";'>You're now heavily pregnant!</b>"
						+ "</p>";
			} else {
				return "<p>"
							+ "Even though the change has been gradual, you're suddenly hit by the familiar realisation that your belly has swollen massively."
							+ " You can't resist rubbing your hands over the bump in your abdomen, smiling fondly at the comforting feeling."
							+ " Having been through all this before, you know that you've still got a way to go before you're ready to give birth, and, giving your belly one final stroke, you continue on your way."
						+ "</p>"
							+ "<p style='text-align:center;'>" + "<b style='color:" + Colour.GENERIC_SEX.toWebHexString() + ";'>You're now heavily pregnant!</b>"
						+ "</p>";
			}
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return false;
		}
		
		@Override
		public boolean isSexEffect() {
			return true;
		}
	},
	PREGNANT_2(
			80,
			"heavily pregnant",
			"pregnancy2",
			Colour.GENERIC_ARCANE,
			true,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.RESISTANCE_PURE, 10f)),
			null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			if(target.isPlayer())
				return "Your stomach has swollen considerably, making it clearly obvious to anyone who glances your way that you're expecting to give birth soon."
						+ " Due to the fact that the arcane accelerates people's pregnancies, you'll move onto the final stage in a matter of days.";
			else
				return UtilText.parse(target,
							"[npc.Name]'s stomach has swollen considerably, making it clearly obvious to anyone who glances [npc.her] way that [npc.she]'s expecting to give birth soon.");
		}

		@Override
		public String extraRemovalEffects(GameCharacter target) {

			target.setTimeProgressedToFinalPregnancyStage(Main.game.getMinutesPassed());

			if (!Main.game.getPlayer().isSideQuestCompleted(QuestLine.SIDE_FIRST_TIME_PREGNANCY)) {
				return "<p>"
							+ "By now, your stomach has completely ballooned out in front of you, and you're having to arch your back and support yourself with one hand as you walk around."
							+ (Main.game.getPlayer().getVaginaType()==VaginaType.HARPY
								?" Although you can feel the hard shells of your clutch of eggs pressing out against the inner walls of your womb, you don't find the sensation to be in any way uncomfortable."
									+ " If anything, the feeling only seems to be boosting your maternal instincts, and you often catch yourself daydreaming about laying and incubating your eggs."
								:" Some time in the last couple of hours, you felt a strange rumble in your pregnant bump, and after panicking for a little while, you realised that it was your offspring kicking about in your womb."
									+ " You keep feeling another kick every now and then, and you know that you're ready to give birth.")
						+ "</p>"
						+ "<p>"
							+ UtilText.parsePlayerThought("I really should go and see Lilaya...")
						+ "</p>"
						+ "<p style='text-align:center;'>"
							+ "<b style='color:" + Colour.GENERIC_SEX.toWebHexString() + ";'>You're now ready to give birth!</b>" 
						+ "</p>";
			} else {
				return "<p>"
							+ "By now, your stomach has completely ballooned out in front of you, and you're having to arch your back and support yourself with one hand as you walk around."
							+ (Main.game.getPlayer().getVaginaType()==VaginaType.HARPY
							?" Although you can feel the hard shells of your clutch of eggs pressing out against the inner walls of your womb, you don't find the sensation to be in any way uncomfortable."
								+ " If anything, the feeling only seems to be boosting your maternal instincts, and you often catch yourself daydreaming about laying and incubating your eggs."
							:" Some time in the last couple of hours, you felt a familiar rumble in your pregnant bump, and from experience, you instantly recognised that it was your offspring kicking about in your womb."
								+ " You keep feeling another kick every now and then, and you know that you're ready to give birth.")
						+ "</p>"
						+ "<p>"
							+ UtilText.parsePlayerThought("I really should go and see Lilaya... Or maybe I'll stay like this for a little while!")
						+ "</p>"
						+ "<p style='text-align:center;'>"
							+ "<b style='color:" + Colour.GENERIC_SEX.toWebHexString()+ ";'>You're now ready to give birth!</b>"
						+ "</p>";
			}
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return false;
		}
		
		@Override
		public boolean isSexEffect() {
			return true;
		}
	},
	PREGNANT_3(
			80,
			"ready for birthing",
			"pregnancy3",
			Colour.GENERIC_ARCANE,
			true,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.RESISTANCE_PURE, 15f)),
			null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			if(target.isPlayer())
				return "Your belly has inflated to a colossal size, and you find yourself having to support your back as you walk."
						+ " It might be a good idea to visit Lilaya so that she can help you to give birth.";
			else
				return UtilText.parse(target,
							"[npc.Name]'s belly has inflated to a colossal size, and [npc.she]'s finding that [npc.she] has to support [npc.her] back with one hand as [npc.she] walks.");
		}
		
		@Override
		public String extraRemovalEffects(GameCharacter target) {
			if(target instanceof NPC)
				((NPC)target).setReactedToPregnancy(false);
			
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return target.isPregnant()
					 && !target.hasStatusEffect(StatusEffect.PREGNANT_0)
					 && !target.hasStatusEffect(StatusEffect.PREGNANT_1)
					 && !target.hasStatusEffect(StatusEffect.PREGNANT_2);
		}
		
		@Override
		public boolean isSexEffect() {
			return true;
		}
	},

	VIXENS_VIRILITY(
			80,
			"Vixen's Virility",
			"vixensVirility",
			Colour.GENERIC_SEX,
			true,
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.FERTILITY, 50f),
					new Value<Attribute, Float>(Attribute.VIRILITY, 50f)),
			null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			return "After consuming a Vixen's Virility pill, your body's fertility and virility have been temporarily boosted.";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return false;
		}
		
		@Override
		public boolean isSexEffect() {
			return true;
		}
	},

	PROMISCUITY_PILL(
			80,
			"Promiscuity Pill",
			"promiscuityPill",
			Colour.GENERIC_SEX,
			true,
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.FERTILITY, -100f),
					new Value<Attribute, Float>(Attribute.VIRILITY, -100f)),
			null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			return "After consuming a Promiscuity Pill, your body's fertility and virility has been temporarily reduced."
					+ " This is a <b>preventative</b> measure, and will not alter the outcome of any unprotected sex you had before taking the pill!";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return false;
		}
		
		@Override
		public boolean isSexEffect() {
			return true;
		}
	},

	RECOVERING_ORIFICE(
			80,
			"Recovering Vagina",
			"recoveringOrifice",
			Colour.GENERIC_SEX,
			false,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.FITNESS, -2f), new Value<Attribute, Float>(Attribute.STRENGTH, -2f), new Value<Attribute, Float>(Attribute.HEALTH_MAXIMUM, -5f)),
			null) {

		@Override
		public String getName(GameCharacter target) {
			int i=0;
			String s="";
			
			// Vagina:
			if (target.getVaginaRawCapacityValue()!=target.getVaginaStretchedCapacity()){
				s = "Recovering Vagina";
				i++;
				
			// Ass:
			}
			if (target.getAssRawCapacityValue()!=target.getAssStretchedCapacity()){
				s = "Recovering Anus";
				i++;
				
			// Nipples:
			}
			if (target.getBreastRawCapacityValue()!=target.getBreastStretchedCapacity()){
				s = "Recovering Nipples";
				i++;
				
			// Urethra:
			}
			if (target.getPenisRawCapacityValue()!=target.getPenisStretchedCapacity()){
				s = "Recovering Urethra";
				i++;
			}
			
			if(i>1)
				return "Recovering Orifices";
			else
				return s;
		}
		
		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			
			// Vagina:
			if (target.getVaginaRawCapacityValue()!=target.getVaginaStretchedCapacity()){
				switch(target.getVaginaElasticity()){
					//Takes 6 hours to recover each inch of capacity:
					case ZERO_UNYIELDING:
						target.incrementVaginaStretchedCapacity(-(1/6f) * (minutesPassed/60f));
						break;
					//Takes 4 hours to recover each inch of capacity:
					case ONE_RIGID:
						target.incrementVaginaStretchedCapacity(-(1/4f) * (minutesPassed/60f));
						break;
					//Takes 2 hours to recover each inch of capacity:
					case TWO_FIRM:
						target.incrementVaginaStretchedCapacity(-(1/2f) * (minutesPassed/60f));
						break;
					//Takes 1 hour to recover each inch of capacity:
					case THREE_FLEXIBLE:
						target.incrementVaginaStretchedCapacity(-1 * (minutesPassed/60f));
						break;
					//Takes 1 hour to recover each inch of capacity:
					case FOUR_LIMBER:
						target.incrementVaginaStretchedCapacity(-1 * (minutesPassed/60f));
						break;
					//Takes 30 minutes to recover each inch of capacity:
					case FIVE_STRETCHY:
						target.incrementVaginaStretchedCapacity(-2 * (minutesPassed/60f));
						break;
					//Takes 15 minutes to recover each inch of capacity:
					case SIX_SUPPLE:
						target.incrementVaginaStretchedCapacity(-4 * (minutesPassed/60f));
						break;
					//Should have been instant after sex, this is just a backup:
					case SEVEN_ELASTIC:
						target.incrementVaginaStretchedCapacity(-100);
						break;
					default:
						break;
				}
			
				if(target.getVaginaStretchedCapacity()<target.getVaginaRawCapacityValue())
					target.setVaginaStretchedCapacity(target.getVaginaRawCapacityValue());
			}
			
			// Ass:
			if (target.getAssRawCapacityValue()!=target.getAssStretchedCapacity()){
				switch(target.getAssElasticity()){
					//Takes 6 hours to recover each inch of capacity:
					case ZERO_UNYIELDING:
						target.incrementAssStretchedCapacity(-(1/6f) * (minutesPassed/60f));
						break;
					//Takes 4 hours to recover each inch of capacity:
					case ONE_RIGID:
						target.incrementAssStretchedCapacity(-(1/4f) * (minutesPassed/60f));
						break;
					//Takes 2 hours to recover each inch of capacity:
					case TWO_FIRM:
						target.incrementAssStretchedCapacity(-(1/2f) * (minutesPassed/60f));
						break;
					//Takes 1 hour to recover each inch of capacity:
					case THREE_FLEXIBLE:
						target.incrementAssStretchedCapacity(-1 * (minutesPassed/60f));
						break;
					//Takes 1 hour to recover each inch of capacity:
					case FOUR_LIMBER:
						target.incrementAssStretchedCapacity(-1 * (minutesPassed/60f));
						break;
					//Takes 30 minutes to recover each inch of capacity:
					case FIVE_STRETCHY:
						target.incrementAssStretchedCapacity(-2 * (minutesPassed/60f));
						break;
					//Takes 15 minutes to recover each inch of capacity:
					case SIX_SUPPLE:
						target.incrementAssStretchedCapacity(-4 * (minutesPassed/60f));
						break;
					//Should have been instant after sex, this is just a backup:
					case SEVEN_ELASTIC:
						target.incrementAssStretchedCapacity(-100);
						break;
					default:
						break;
				}
				
				if(target.getAssStretchedCapacity()<target.getAssRawCapacityValue())
					target.setAssStretchedCapacity(target.getAssRawCapacityValue());
			}
			
			// Nipples:
			if (target.getBreastRawCapacityValue()!=target.getBreastStretchedCapacity()){
				switch(target.getBreastElasticity()){
					//Takes 6 hours to recover each inch of capacity:
					case ZERO_UNYIELDING:
						target.incrementBreastStretchedCapacity(-(1/6f) * (minutesPassed/60f));
						break;
					//Takes 4 hours to recover each inch of capacity:
					case ONE_RIGID:
						target.incrementBreastStretchedCapacity(-(1/4f) * (minutesPassed/60f));
						break;
					//Takes 2 hours to recover each inch of capacity:
					case TWO_FIRM:
						target.incrementBreastStretchedCapacity(-(1/2f) * (minutesPassed/60f));
						break;
					//Takes 1 hour to recover each inch of capacity:
					case THREE_FLEXIBLE:
						target.incrementBreastStretchedCapacity(-1 * (minutesPassed/60f));
						break;
					//Takes 1 hour to recover each inch of capacity:
					case FOUR_LIMBER:
						target.incrementBreastStretchedCapacity(-1 * (minutesPassed/60f));
						break;
					//Takes 30 minutes to recover each inch of capacity:
					case FIVE_STRETCHY:
						target.incrementBreastStretchedCapacity(-2 * (minutesPassed/60f));
						break;
					//Takes 15 minutes to recover each inch of capacity:
					case SIX_SUPPLE:
						target.incrementBreastStretchedCapacity(-4 * (minutesPassed/60f));
						break;
					//Should have been instant after sex, this is just a backup:
					case SEVEN_ELASTIC:
						target.incrementBreastStretchedCapacity(-100);
						break;
					default:
						break;
				}
				
				if(target.getBreastStretchedCapacity()<target.getBreastRawCapacityValue())
					target.setBreastStretchedCapacity(target.getBreastRawCapacityValue());
			}
			
			// Urethra:
			if (target.getPenisRawCapacityValue()!=target.getPenisStretchedCapacity()){
				switch(target.getPenisElasticity()){
					//Takes 6 hours to recover each inch of capacity:
					case ZERO_UNYIELDING:
						target.incrementPenisStretchedCapacity(-(1/6f) * (minutesPassed/60f));
						break;
					//Takes 4 hours to recover each inch of capacity:
					case ONE_RIGID:
						target.incrementPenisStretchedCapacity(-(1/4f) * (minutesPassed/60f));
						break;
					//Takes 2 hours to recover each inch of capacity:
					case TWO_FIRM:
						target.incrementPenisStretchedCapacity(-(1/2f) * (minutesPassed/60f));
						break;
					//Takes 1 hour to recover each inch of capacity:
					case THREE_FLEXIBLE:
						target.incrementPenisStretchedCapacity(-1 * (minutesPassed/60f));
						break;
					//Takes 1 hour to recover each inch of capacity:
					case FOUR_LIMBER:
						target.incrementPenisStretchedCapacity(-1 * (minutesPassed/60f));
						break;
					//Takes 30 minutes to recover each inch of capacity:
					case FIVE_STRETCHY:
						target.incrementPenisStretchedCapacity(-2 * (minutesPassed/60f));
						break;
					//Takes 15 minutes to recover each inch of capacity:
					case SIX_SUPPLE:
						target.incrementPenisStretchedCapacity(-4 * (minutesPassed/60f));
						break;
					//Should have been instant after sex, this is just a backup:
					case SEVEN_ELASTIC:
						target.incrementPenisStretchedCapacity(-100);
						break;
					default:
						break;
				}
				
				if(target.getPenisStretchedCapacity()<target.getPenisRawCapacityValue())
					target.setPenisStretchedCapacity(target.getPenisRawCapacityValue());
			}
			
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			
			descriptionSB = new StringBuilder("The following orifices are recovering:");
			
			// Vagina:
			if (target.getVaginaRawCapacityValue()!=target.getVaginaStretchedCapacity()){
				descriptionSB.append("</br><b>Vagina:</b> From "+Capacity.getCapacityFromValue(target.getVaginaStretchedCapacity()).getDescriptor()+" to "+target.getVaginaCapacity().getDescriptor()+".");
				
			// Ass:
			}
			if (target.getAssRawCapacityValue()!=target.getAssStretchedCapacity()){
				descriptionSB.append("</br><b>Anus:</b> From "+Capacity.getCapacityFromValue(target.getAssStretchedCapacity()).getDescriptor()+" to "+target.getAssCapacity().getDescriptor()+".");
				
			// Nipples:
			}
			if (target.getBreastRawCapacityValue()!=target.getBreastStretchedCapacity()){
				descriptionSB.append("</br><b>Nipples:</b> From "+Capacity.getCapacityFromValue(target.getBreastStretchedCapacity()).getDescriptor()+" to "+target.getBreastCapacity().getDescriptor()+".");
				
			// Urethra:
			}
			if (target.getPenisRawCapacityValue()!=target.getPenisStretchedCapacity()){
				descriptionSB.append("</br><b>Urethra:</b> From "+Capacity.getCapacityFromValue(target.getPenisStretchedCapacity()).getDescriptor()+" to "+target.getPenisCapacity().getDescriptor()+".");
			}
			
			return descriptionSB.toString();
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return !Main.game.isInSex() &&
					((target.hasVagina() && target.getVaginaRawCapacityValue()!=target.getVaginaStretchedCapacity())
					|| (target.getAssRawCapacityValue()!=target.getAssStretchedCapacity())
					|| (target.getBreastRawCapacityValue()!=target.getBreastStretchedCapacity())
					|| (target.getPenisRawCapacityValue()!=target.getPenisStretchedCapacity()));
		}
	},

	CREAMPIE_VAGINA(
			80,
			"Pussy Creampie",
			"creampie",
			Colour.CUMMED,
			false,
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.FITNESS, -2f),
					new Value<Attribute, Float>(Attribute.INTELLIGENCE, -2f)),
			Util.newArrayListOfValues(
					new ListValue<String>("<b style='color: " + Colour.ATTRIBUTE_CORRUPTION.toWebHexString() + "'>Dirties clothing</b>"))) {
		
		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			if(target.getLowestZLayerCoverableArea(CoverableArea.VAGINA)!=null){
				if(!target.getLowestZLayerCoverableArea(CoverableArea.VAGINA).isDirty()){
					target.getLowestZLayerCoverableArea(CoverableArea.VAGINA).setDirty(true);
					return "<p>"
							+ "Cum leaks out of your creampied pussy, quickly </b><b style='color:"+Colour.CUMMED.toWebHexString()+";'>dirtying</b> your "+target.getLowestZLayerCoverableArea(CoverableArea.VAGINA).getName()+"!"
							+ "</p>";
				}
			}
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			if(target.isPlayer())
				return "As you walk, you can feel slimy cum drooling out of your recently-used pussy."
						+ " You find it hard to concentrate on anything other than the memory of being creampied.</br>"
						+ "Perhaps you should take a shower...";
			else
				return target.getName("The")+"'s "+target.getVaginaName(true)+" has recently been filled with cum.";
		}
		
		@Override
		public String extraRemovalEffects(GameCharacter target) {
			if(target.isPlayer()) {
				target.clearCummedInArea(OrificeType.VAGINA_PLAYER);
			} else {
				target.clearCummedInArea(OrificeType.VAGINA_PARTNER);
			}
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return false;
		}
		
		@Override
		public boolean isSexEffect() {
			return true;
		}
	},
	CREAMPIE_ANUS(
			80,
			"Anal Creampie",
			"creampie",
			Colour.CUMMED,
			false,
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.FITNESS, -2f),
					new Value<Attribute, Float>(Attribute.INTELLIGENCE, -2f)),
			Util.newArrayListOfValues(new ListValue<String>("<b style='color: "
					+ Colour.ATTRIBUTE_CORRUPTION.toWebHexString()
					+ "'>Dirties clothing</b>"))) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			if(target.getLowestZLayerCoverableArea(CoverableArea.ANUS)!=null){
				if(!target.getLowestZLayerCoverableArea(CoverableArea.ANUS).isDirty()){
					target.getLowestZLayerCoverableArea(CoverableArea.ANUS).setDirty(true);
					return "<p>"
							+ "Cum leaks out of your creampied asshole, quickly </b><b style='color:"+Colour.CUMMED.toWebHexString()+";'>dirtying</b> your "+target.getLowestZLayerCoverableArea(CoverableArea.ANUS).getName()+"!"
							+ "</p>";
				}
			}
			
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			if(target.isPlayer())
				return "As you walk, you can feel slimy cum drooling out of your recently-used asshole."
						+ " You find it hard to concentrate on anything other than the memory of being creampied.</br>"
						+ "Perhaps you should take a shower...";
			else
				return target.getName("The")+"'s "+target.getAssholeName(true)+" has recently been filled with cum.";
		}
		
		@Override
		public String extraRemovalEffects(GameCharacter target) {
			if(target.isPlayer()) {
				target.clearCummedInArea(OrificeType.ANUS_PLAYER);
			} else {
				target.clearCummedInArea(OrificeType.ANUS_PARTNER);
			}
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return false;
		}
		
		@Override
		public boolean isSexEffect() {
			return true;
		}

	},
	CREAMPIE_NIPPLES(
			80,
			"Nipple Creampie",
			"creampie",
			Colour.CUMMED,
			false,
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.FITNESS, -2f),
					new Value<Attribute, Float>(Attribute.INTELLIGENCE, -2f)),
			Util.newArrayListOfValues(new ListValue<String>("<b style='color: "
					+ Colour.ATTRIBUTE_CORRUPTION.toWebHexString()
					+ "'>Dirties clothing</b>"))) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			if(target.getLowestZLayerCoverableArea(CoverableArea.NIPPLES)!=null){
				if(!target.getLowestZLayerCoverableArea(CoverableArea.NIPPLES).isDirty()){
					target.getLowestZLayerCoverableArea(CoverableArea.NIPPLES).setDirty(true);
					return "<p>"
							+ "Cum leaks out of your creampied nipples, quickly </b><b style='color:"+Colour.CUMMED.toWebHexString()+";'>dirtying</b> your "+target.getLowestZLayerCoverableArea(CoverableArea.NIPPLES).getName()+"!"
							+ "</p>";
				}
			}
			
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			if(target.isPlayer())
				return "As you walk, you can feel slimy cum drooling out of your recently-used nipples."
						+ " You find it hard to concentrate on anything other than the memory of being creampied.</br>"
						+ "Perhaps you should take a shower...";
			else
				return target.getName("The")+"'s "+target.getNippleName(true)+" have recently been filled with cum.";
		}
		
		@Override
		public String extraRemovalEffects(GameCharacter target) {
			if(target.isPlayer()) {
				target.clearCummedInArea(OrificeType.NIPPLE_PLAYER);
			} else {
				target.clearCummedInArea(OrificeType.NIPPLE_PARTNER);
			}
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return false;
		}
		
		@Override
		public boolean isSexEffect() {
			return true;
		}
	},
	CREAMPIE_PENIS(
			80,
			"Urethral Creampie",
			"creampie",
			Colour.CUMMED,
			false,
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.FITNESS, -2f),
					new Value<Attribute, Float>(Attribute.INTELLIGENCE, -2f)),
			Util.newArrayListOfValues(new ListValue<String>("<b style='color: "
					+ Colour.ATTRIBUTE_CORRUPTION.toWebHexString()
					+ "'>Dirties clothing</b>"))) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			if(target.getLowestZLayerCoverableArea(CoverableArea.PENIS)!=null){
				if(!target.getLowestZLayerCoverableArea(CoverableArea.PENIS).isDirty()){
					target.getLowestZLayerCoverableArea(CoverableArea.PENIS).setDirty(true);
					return "<p>"
							+ "Cum leaks out of your creampied urethra, quickly </b><b style='color:"+Colour.CUMMED.toWebHexString()+";'>dirtying</b> your "+target.getLowestZLayerCoverableArea(CoverableArea.PENIS).getName()+"!"
							+ "</p>";
				}
			}
			
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			if(target.isPlayer())
				return "As you walk, you can feel slimy cum drooling out of your recently-used urethra."
						+ " You find it hard to concentrate on anything other than the memory of being creampied.</br>"
						+ "Perhaps you should take a shower...";
			else
				return target.getName("The")+"'s urethra has recently been filled with cum.";
		}
		
		@Override
		public String extraRemovalEffects(GameCharacter target) {
			if(target.isPlayer()) {
				target.clearCummedInArea(OrificeType.URETHRA_PLAYER);
			} else {
				target.clearCummedInArea(OrificeType.URETHRA_PARTNER);
			}
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return false;
		}
		
		@Override
		public boolean isSexEffect() {
			return true;
		}
	},
	
	FRUSTRATED_NO_ORGASM(
			80,
			"Frustrated",
			"frustrated",
			Colour.GENERIC_BAD,
			false,
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.RESISTANCE_MANA, -50f),
					new Value<Attribute, Float>(Attribute.DAMAGE_SPELLS, -10f)),
			null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			if(target.isPlayer()) {
				return "You've recently had a sexual encounter in which you didn't manage to orgasm."
						+ " As a result, you're feeling extremely horny and frustrated...";
			} else {
				return UtilText.parse(target, "[npc.Name] recently had a sexual encounter in which [npc.she] didn't manage to orgasm."
						+ " As a result, [npc.she]'s feeling extremely horny and frustrated...");
			}
		}
		
		@Override
		public String extraRemovalEffects(GameCharacter target) {
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return false;
		}
		
		@Override
		public boolean isSexEffect() {
			return true;
		}
	},
	
	RECOVERING_AURA(
			80,
			"Strengthened aura",
			"recoveringAura",
			Colour.GENERIC_ARCANE,
			false,
			Util.newHashMapOfValues(
					new Value<Attribute, Float>(Attribute.RESISTANCE_MANA, 25f)),
			null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			if(target.isPlayer()) {
				return "Due to a recent orgasm, your arcane aura has been temporarily strengthened."
						+ " While in this state, you will no longer receive an arcane essence if you orgasm!";
			} else {
				return UtilText.parse(target, "Due to a recent orgasm, [npc.name]'s arcane aura has been temporarily strengthened."
						+ " While [npc.she] remains in this state, you will not receive an arcane essence if [npc.she] orgasms in your presence!");
			}
		}
		
		@Override
		public String extraRemovalEffects(GameCharacter target) {
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return false;
		}
		
		@Override
		public boolean isSexEffect() {
			return true;
		}
	},

	EXPOSED(
			80,
			"exposed",
			"clothingExposed",
			Colour.GENERIC_BAD,
			false,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.INTELLIGENCE, -4f)),
			null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			return "Your clothing doesn't cover your private parts, and you feel highly embarrassed to be walking around in such an exposed fashion.";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return !Main.game.isInSex()
					&& !target.hasFetish(Fetish.FETISH_EXHIBITIONIST)
					&& (target.isCoverableAreaExposed(CoverableArea.ANUS)
							|| (target.isCoverableAreaExposed(CoverableArea.PENIS) && target.getPenisType() != PenisType.NONE)
							|| (target.isCoverableAreaExposed(CoverableArea.VAGINA) && target.getVaginaType() != VaginaType.NONE))
					&& !(target.hasBreasts() && target.isCoverableAreaExposed(CoverableArea.NIPPLES)); 
		}
	},
	
	EXPOSED_BREASTS(
			80,
			"exposed breasts",
			"clothingExposed",
			Colour.GENERIC_BAD,
			false,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.INTELLIGENCE, -2f)),
			null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			return "Your clothing doesn't cover your breasts, and you feel highly embarrassed to be walking around in such an exposed fashion.";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return !Main.game.isInSex()
					&& !target.hasFetish(Fetish.FETISH_EXHIBITIONIST)
					&& !(target.isCoverableAreaExposed(CoverableArea.ANUS)
							|| (target.isCoverableAreaExposed(CoverableArea.PENIS) && target.getPenisType() != PenisType.NONE)
							|| (target.isCoverableAreaExposed(CoverableArea.VAGINA) && target.getVaginaType() != VaginaType.NONE))
					&& (target.hasBreasts() && target.isCoverableAreaExposed(CoverableArea.NIPPLES)); 
		}
	},
	
	EXPOSED_PLUS_BREASTS(
			80,
			"exposed",
			"clothingExposed",
			Colour.GENERIC_BAD,
			false,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.INTELLIGENCE, -6f)),
			null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			return "Your breasts and private parts are naked for the world to see, and you feel highly embarrassed to be walking around in such an exposed fashion.";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return !Main.game.isInSex()
					&& !target.hasFetish(Fetish.FETISH_EXHIBITIONIST)
					&& (target.isCoverableAreaExposed(CoverableArea.ANUS)
							|| (target.isCoverableAreaExposed(CoverableArea.PENIS) && target.getPenisType() != PenisType.NONE)
							|| (target.isCoverableAreaExposed(CoverableArea.VAGINA) && target.getVaginaType() != VaginaType.NONE))
					&& (target.hasBreasts() && target.isCoverableAreaExposed(CoverableArea.NIPPLES)); 
		}
	},
	
	FETISH_EXHIBITIONIST(
			80,
			"exhibitionist",
			"clothingExposed",
			Colour.GENERIC_SEX,
			false,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.DAMAGE_MANA, 8f)),
			null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			return "Your clothing doesn't cover your private parts, and you feel incredibly sexy every time you catch someone staring at your exposed groin.";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return !Main.game.isInSex()
					&& (target.hasFetish(Fetish.FETISH_EXHIBITIONIST)// Exhibitionist
						&& (target.isCoverableAreaExposed(CoverableArea.ANUS)
							|| (target.isCoverableAreaExposed(CoverableArea.PENIS) && target.getPenisType() != PenisType.NONE)
							|| (target.isCoverableAreaExposed(CoverableArea.VAGINA) && target.getVaginaType() != VaginaType.NONE) 
							|| ((target.isCoverableAreaExposed(CoverableArea.PENIS) || target.isCoverableAreaExposed(CoverableArea.VAGINA)) && (target.getPenisType() == PenisType.NONE && target.getVaginaType() == VaginaType.NONE)))
						&& !(target.getBreastSize() != CupSize.FLAT && target.isCoverableAreaExposed(CoverableArea.NIPPLES)));
		}
	},
	FETISH_EXHIBITIONIST_BREASTS(
			80,
			"exhibitionist",
			"clothingExposed",
			Colour.GENERIC_SEX,
			false,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.DAMAGE_MANA, 4f)),
			null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			return "Your clothing doesn't cover your breasts, and you feel incredibly sexy every time you catch someone staring at your exposed chest.";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return !Main.game.isInSex()
					&& (target.hasFetish(Fetish.FETISH_EXHIBITIONIST)
						&& (!(target.isCoverableAreaExposed(CoverableArea.PENIS) && target.getPenisType() != PenisType.NONE)
							&& !(target.isCoverableAreaExposed(CoverableArea.VAGINA) && target.getVaginaType() != VaginaType.NONE)
							&& !((target.isCoverableAreaExposed(CoverableArea.PENIS) || target.isCoverableAreaExposed(CoverableArea.VAGINA)) && (target.getPenisType() == PenisType.NONE && target.getVaginaType() == VaginaType.NONE)))
						&& (target.getBreastSize() != CupSize.FLAT && target.isCoverableAreaExposed(CoverableArea.NIPPLES)));
		}
	},
	FETISH_EXHIBITIONIST_PLUS_BREASTS(
			80,
			"exhibitionist",
			"clothingExposed",
			Colour.GENERIC_SEX,
			false,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.DAMAGE_MANA, 12f)),
			null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			return "Your breasts and private parts are naked for the world to see, and you feel incredibly sexy as you walk around with all your goods on display.";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return !Main.game.isInSex()
					&& (target.hasFetish(Fetish.FETISH_EXHIBITIONIST)
						&& (target.isCoverableAreaExposed(CoverableArea.ANUS)
							|| (target.isCoverableAreaExposed(CoverableArea.PENIS) && target.getPenisType() != PenisType.NONE)
							|| (target.isCoverableAreaExposed(CoverableArea.VAGINA) && target.getVaginaType() != VaginaType.NONE)
							|| ((target.isCoverableAreaExposed(CoverableArea.PENIS) || target.isCoverableAreaExposed(CoverableArea.VAGINA)) && (target.getPenisType() == PenisType.NONE && target.getVaginaType() == VaginaType.NONE)))
						&& (target.getBreastSize() != CupSize.FLAT && target.isCoverableAreaExposed(CoverableArea.NIPPLES)));
		}
	},

	FETISH_PURE_VIRGIN(
			80,
			"pure virgin",
			"virginPure",
			Colour.GENERIC_EXCELLENT,
			true,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.RESISTANCE_MANA, 50f), new Value<Attribute, Float>(Attribute.RESISTANCE_PURE, 25f), new Value<Attribute, Float>(Attribute.DAMAGE_PURE, 25f)),
			null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			if(target.isPlayer()) {
				return "You represent the perfect image of a pure, righteous being. Your noble bearing and virtuous personality mark you as a paragon of all that is angelic and good in this world.";
			} else {
				return UtilText.parse(target,
						"[npc.Name] represents the perfect image of a pure, righteous being. [npc.Her] noble bearing and virtuous personality mark [npc.herHim] as a paragon of all that is angelic and good in this world.");
			}
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return target.hasFetish(Fetish.FETISH_PURE_VIRGIN) && target.hasVagina() && target.isVaginaVirgin();
		}
		
		@Override
		public boolean isSexEffect() {
			return true;
		}
	},
	FETISH_BROKEN_VIRGIN(
			80,
			"broken virgin",
			"virginBroken",
			Colour.GENERIC_TERRIBLE,
			false,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.RESISTANCE_MANA, -50f),
					new Value<Attribute, Float>(Attribute.CORRUPTION, 50f), new Value<Attribute, Float>(Attribute.RESISTANCE_PURE, -25f)),
			null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			if(target.isPlayer()) {
				return "Losing your virginity has hit you hard. All you can think of is big, thick cocks breaking you in like a worthless slut, before defiling your womb with their foul cum..."
						+ " Without your virginty, all you can see yourself as is a cheap sex toy.";
			} else {
				return UtilText.parse(target,
						"Losing [npc.her] virginity has hit [npc.name] hard. All [npc.she] can think of is big, thick cocks breaking [npc.herHim] in like a worthless slut, before defiling [npc.her] womb with their foul cum..."
								+ " Without [npc.her] virginty, all [npc.she] can see [npc.herself] as is a cheap sex toy.");
			}
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return target.hasFetish(Fetish.FETISH_PURE_VIRGIN) && target.hasVagina() && !target.isVaginaVirgin();
		}
		
		@Override
		public boolean isSexEffect() {
			return true;
		}
	},

	// CLOTHING SETS:
	// (attribute bonuses are handled in the ClothingSet enum, leave all
	// attribute modifiers as null)
	SET_MAID(
			70,
			"Hard-working Maid",
			"maidIcon",
			Colour.CLOTHING_BLACK,
			true,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.FITNESS, 10f), new Value<Attribute, Float>(Attribute.DAMAGE_MANA, 10f)),
			null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			return "By wearing the entire Maid's Outfit, you are filled with the energy you need in order to be a sexy hard-working maid.";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			int setCount = 0;

			for (AbstractClothing c : target.getClothingCurrentlyEquipped())
				if (c.getClothingType().getClothingSet() == ClothingSet.MAID)
					setCount++;

			if (setCount >= ClothingSet.MAID.getNumberRequiredForCompleteSet())
				return true;
			else
				return false;
		}
	},
	SET_ENFORCER(
			70,
			"enforcer's uniform",
			"enforcerIcon",
			Colour.CLOTHING_WHITE,
			true,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.STRENGTH, 10f), new Value<Attribute, Float>(Attribute.FITNESS, 5f), new Value<Attribute, Float>(Attribute.RESISTANCE_PHYSICAL, 15f)), null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			if(target!=null) {
				if(target.isPlayer())
					return "By wearing an Enforcer's uniform, you gain the energy and strength you need to fight crime.";
				else
					return UtilText.genderParsing(target,
							target.getName("The")+" is wearing an Enforcer's uniform, granting <herPro> the energy and strength <she> needs to fight crime.");
			}
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			int setCount = 0;

			for (AbstractClothing c : target.getClothingCurrentlyEquipped())
				if (c.getClothingType().getClothingSet() == ClothingSet.ENFORCER)
					setCount++;

			if (setCount >= ClothingSet.ENFORCER.getNumberRequiredForCompleteSet())
				return true;
			else
				return false;
		}
	},
	SET_RAINBOW(
			70,
			"double rainbow",
			"rainbowIcon",
			Colour.CLOTHING_WHITE,
			true,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.FITNESS, 5f)),
			null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			return "What does it mean?";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			int setCount = 0;

			for (AbstractClothing c : target.getClothingCurrentlyEquipped())
				if (c.getClothingType().getClothingSet() == ClothingSet.RAINBOW)
					setCount++;

			if (setCount >= ClothingSet.RAINBOW.getNumberRequiredForCompleteSet())
				return true;
			else
				return false;
		}
	},
	SET_BDSM(
			70,
			"BDSM",
			"bdsmIcon",
			Colour.CLOTHING_WHITE,
			false,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.FITNESS, -15f), new Value<Attribute, Float>(Attribute.STRENGTH, -15f)),
			null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			return "You have been tied up in bondage gear, and are struggling to move.";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			int setCount = 0;

			for (AbstractClothing c : target.getClothingCurrentlyEquipped())
				if (c.getClothingType().getClothingSet() == ClothingSet.BDSM)
					setCount++;

			if (setCount >= ClothingSet.BDSM.getNumberRequiredForCompleteSet())
				return true;
			else
				return false;
		}
	},
	
	
	POTION_EFFECTS(
			80,
			"potion effects",
			"potionEffects",
			Colour.GENERIC_ARCANE,
			false,
			null,
			null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			if(target.isPlayer())
				return "After drinking a potion, you are now experiencing some effects...";
			else
				return UtilText.parse(target, "After drinking a potion, [npc.name] is now experiencing some effects...");
		}
		
//		potionAttributes
		public Map<Attribute, Float> getAttributeModifiers(GameCharacter target) {
			return target.getPotionAttributes();
		}
		
		@Override
		public List<String> getModifiersAsStringList(GameCharacter target) {
			modifiersList.clear();
			
			if (getAttributeModifiers(target) != null) {
				for (Entry<Attribute, Float> e : getAttributeModifiers(target).entrySet())
					modifiersList.add("<b>" + (e.getValue() > 0 ? "+" : "") + e.getValue() + "</b>" + " <b style='color: " + e.getKey().getColour().toWebHexString() + ";'>" + Util.capitaliseSentence(e.getKey().getAbbreviatedName()) + "</b>");
			}
					
			return modifiersList;
		}
		
		
		@Override
		public String extraRemovalEffects(GameCharacter target) {
			target.clearPotionAttributes();
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return false;
		}
	},
	

	// COMBAT EFFECTS:
	
	COMBAT_HIDDEN(
			70,
			"hidden",
			"combatHidden",
			Colour.GENERIC_BAD,
			false,
			null,
			null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			return "You don't know what perks, status effects, spells, or special attacks your opponent has available. You require the "+Perk.OBSERVANT.getName(Main.game.getPlayer())+" perk to reveal such information.";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return false;
		}
		
		@Override
		public boolean isCombatEffect() {
			return true;
		}
	},
	ZERO_MANA(
			70,
			"mentally fatigued",
			"outOfMana",
			Colour.ATTRIBUTE_INTELLIGENCE,
			false,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.CRITICAL_CHANCE, -100f)),
			null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			return "You feel completely drained, but due to your indefatigable perk, you aren't ready to give up just yet!";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return target.getMana() == 0 && target.hasPerk(Perk.INDEFATIGABLE);
		}
		
		@Override
		public boolean isCombatEffect() {
			return true;
		}
	},
	ZERO_STAMINA(
			70,
			"fatigued",
			"outOfStamina",
			Colour.ATTRIBUTE_FITNESS,
			false,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.DAMAGE_ATTACK, -50f)),
			null) {

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			return "You are extremely tired, but due to your indefatigable perk, you aren't ready to give up just yet!";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return target.getStamina() == 0 && target.hasPerk(Perk.INDEFATIGABLE);
		}
		
		@Override
		public boolean isCombatEffect() {
			return true;
		}
	},

	// From spells (still in combat):
	
	DAZED(
			10,
			"dazed",
			"negativeCombatEffect",
			Colour.DAMAGE_TYPE_PHYSICAL,
			false,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.DAMAGE_ATTACK, -25f), new Value<Attribute, Float>(Attribute.CRITICAL_CHANCE, -25f)),
			null) {
		
		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			if (target.isPlayer())
				return "Your head is spinning and you're struggling to stay upright. You're finding it incredibly difficult to land a hit on your opponent or dodge one of their attacks.";
			else
				return UtilText.genderParsing(target,
						target.getName("The") + "'s head is spinning and <she>'s struggling to stay upright. <She>'s finding it incredibly difficult to land a hit on you or dodge one of your attacks.");
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return false;
		}
		
		@Override
		public boolean isCombatEffect() {
			return true;
		}
	},
	CRIPPLE(
			10,
			"crippled",
			"negativeCombatEffect",
			Colour.DAMAGE_TYPE_PHYSICAL,
			false,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.DAMAGE_ATTACK, -15f)),
			null) {
		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			if (target.isPlayer())
				return "You've been temporarily crippled, and you're struggling to do as much damage with your attacks as you're usually able to.";
			else
				return UtilText.genderParsing(target,
						target.getName("The") + "'s been temporarily crippled, and <she>'s struggling to do as much damage with <her> attacks as <she>'s usually able to.");
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return false;
		}
		
		@Override
		public boolean isCombatEffect() {
			return true;
		}
	},
	VULNERABLE(
			10,
			"vulnerable",
			"negativeCombatEffect",
			Colour.DAMAGE_TYPE_PHYSICAL,
			false,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.RESISTANCE_PHYSICAL, -15f)),
			null) {
		
		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			if (target.isPlayer())
				return "You're feeling particularly vulnerable, and aren't able to defend yourself to the best of your ability.";
			else
				return UtilText.genderParsing(target, target.getName("The") + " is feeling particularly vulnerable, and <she> isn't able to defend <herPro>self to the best of <her> ability.");
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return false;
		}
		
		@Override
		public boolean isCombatEffect() {
			return true;
		}
	},

	BURN_WEAK(
			10,
			"burn",
			"negativeCombatEffect",
			Colour.DAMAGE_TYPE_FIRE,
			false,
			null,
			Util.newArrayListOfValues(new ListValue<String>("<b>4</b> <b style='color: " + Colour.DAMAGE_TYPE_FIRE.toWebHexString() + ";'>Fire damage per turn</b>"))) {
		
		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			int damage = (int) (4 * ((100 - (target.getAttributeValue(Attribute.RESISTANCE_FIRE))) / 100f)); 
			if (damage < 1)
				damage = 1;
			target.incrementHealth(-damage);

			if (target.isPlayer()) {
				return "You take <b>" + damage + "</b> <b style='color:" + Attribute.DAMAGE_FIRE.getColour().toWebHexString() + ";'>" + DamageType.FIRE.getName() + "</b> damage!";
				
			} else {
				return "[npc.Name] takes <b>" + damage + "</b> <b style='color:" + Attribute.DAMAGE_FIRE.getColour().toWebHexString() + ";'>" + DamageType.FIRE.getName() + "</b> damage!";
			}
		}

		@Override
		public String getDescription(GameCharacter target) {
			if (target.isPlayer()) {
				return "Invisible arcane flames lick at your feet, and while they don't cause you any real pain, you still end up hopping around in discomfort.";
			} else {
				return UtilText.parse(target,
						"Invisible arcane flames lick at [npc.name]'s feet, and while they don't cause [npc.herHim] any real pain, [npc.she] still ends up hopping around in discomfort.");
			}
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return false;
		}
		
		@Override
		public boolean isCombatEffect() {
			return true;
		}
	},
	
	CHILL(
			10,
			"chill",
			"negativeCombatEffect",
			Colour.DAMAGE_TYPE_COLD,
			false,
			null,
			Util.newArrayListOfValues(new ListValue<String>("<b>2</b> <b style='color: "
					+ Colour.DAMAGE_TYPE_MANA.toWebHexString()
					+ ";'>Willpower damage</b>"),
					new ListValue<String>("<b>2</b> <b style='color: " + Colour.DAMAGE_TYPE_STAMINA.toWebHexString() + ";'>Stamina damage</b>"))) {
		
		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			target.incrementMana(-2f);
			target.incrementStamina(-2f);

			if (target.isPlayer()) {
				return "You take <b>2</b> <b style='color:" + Attribute.DAMAGE_STAMINA.getColour().toWebHexString() + ";'>" + DamageType.STAMINA.getName() + "</b> damage and <b>2</b>"
							+ " <b style='color:" + Attribute.DAMAGE_MANA.getColour().toWebHexString() + ";'>" + DamageType.MANA.getName() + "</b> damage!";
				
			} else {
				return "[npc.Name] takes <b>2</b> <b style='color:" + Attribute.DAMAGE_STAMINA.getColour().toWebHexString() + ";'>" + DamageType.STAMINA.getName() + "</b> damage and <b>2</b>"
						+ " <b style='color:" + Attribute.DAMAGE_MANA.getColour().toWebHexString() + ";'>" + DamageType.MANA.getName() + "</b> damage!";
			}
		}

		@Override
		public String getDescription(GameCharacter target) {
			if (target.isPlayer()) {
				return "A fine mist of icy shards is lingering around you. The arcane cold seeps into your body, slowing your movements and dulling your mind.";
			} else {
				return UtilText.parse(target,
						"A fine mist of icy shards is lingering around [npc.name]. The arcane cold is seeping into [npc.her] body, slowing [npc.her] movements and dulling [npc.her] mind.");
			}
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return false;
		}
		
		@Override
		public boolean isCombatEffect() {
			return true;
		}
	},
	
	POISON_WEAK(
			10,
			"poison",
			"negativeCombatEffect",
			Colour.DAMAGE_TYPE_POISON,
			false,
			null,
			Util.newArrayListOfValues(new ListValue<String>("<b>2%</b> <b style='color: "
					+ Colour.DAMAGE_TYPE_POISON.toWebHexString()
					+ ";'>Poison damage per turn</b>"))) {
		@Override
		/**
		 * 2% health damage per tick. Minimum of 1 damage.
		 */
		public String applyEffect(GameCharacter target, int minutesPassed) {
			float damage = (target.getAttributeValue(Attribute.HEALTH_MAXIMUM) * 0.02f) * ((100 - (target.getAttributeValue(Attribute.RESISTANCE_POISON))) / 100f);
			if (damage < 1)
				damage = 1;
			target.incrementHealth(-(int) damage);
			
			if (target.isPlayer()) {
				return "You take <b>" + (int)damage + "</b> <b style='color:" + Attribute.DAMAGE_POISON.getColour().toWebHexString() + ";'>" + DamageType.POISON.getName() + "</b> damage!";
				
			} else {
				return "[npc.Name] takes <b>" + (int)damage + "</b> <b style='color:" + Attribute.DAMAGE_POISON.getColour().toWebHexString() + ";'>"+ DamageType.POISON.getName() + "</b> damage!";
			}
			
		}

		@Override
		public String getDescription(GameCharacter target) {
			if (target.isPlayer()) {
				return "A choking haze of toxic arcane poison is lingering around you, and every time you breathe in, you can taste the sickly miasma in the back of your throat.";
			} else {
				return UtilText.parse(target,
						"A choking haze of toxic arcane poison is lingering around [npc.name], and every time [npc.she] breathes in, the sickly miasma hits the back of [npc.her] throat, causing [npc.herHim] to cough and splutter.");
			}
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return false;
		}
		
		@Override
		public boolean isCombatEffect() {
			return true;
		}
	},
	
	// Shields:
	ARCANE_SHIELD(
			10,
			"arcane shield",
			"positiveCombatEffect",
			Colour.DAMAGE_TYPE_PHYSICAL,
			true,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.RESISTANCE_PHYSICAL, 50f)),
			null) {
		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			if (target.isPlayer())
				return "A swirling vortex of arcane energy has surrounded you, granting you a considerable boost to your physical resistance." + " The energy is also helping to focus your mind, granting a boost to your hit and dodge chances.";
			else
				return UtilText.genderParsing(target, "A swirling vortex of arcane energy has surrounded " + target.getName("the")
						+ ", granting <herPro> a considerable boost to <her> physical resistance." + " The energy is also helping to focus <her> mind, granting a boost to <her> hit and dodge chances.");
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return false;
		}
		
		@Override
		public boolean isCombatEffect() {
			return true;
		}
	},
	FIRE_SHIELD(
			10,
			"fire shield",
			"positiveCombatEffect",
			Colour.DAMAGE_TYPE_FIRE,
			true,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.RESISTANCE_FIRE, 50f), new Value<Attribute, Float>(Attribute.RESISTANCE_PHYSICAL, 15f)),
			null) {
		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			if (target.isPlayer())
				return "A swirling vortex of arcane fire has surrounded you, granting you a considerable boost to your fire resistance." + " The arcane flames also help to mitigate any physical attacks directed your way.";
			else
				return UtilText.genderParsing(target, "A swirling vortex of arcane fire has surrounded " + target.getName("the") + ", granting <herPro> a considerable boost to <her> fire resistance."
						+ " The arcane flames also help to mitigate any physical attacks directed <her> way.");
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return false;
		}
		
		@Override
		public boolean isCombatEffect() {
			return true;
		}
	},
	ICE_SHIELD(
			10,
			"ice shield",
			"positiveCombatEffect",
			Colour.DAMAGE_TYPE_COLD,
			true,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.RESISTANCE_ICE, 50f), new Value<Attribute, Float>(Attribute.RESISTANCE_MANA, 15f)),
			null) {
		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			if (target.isPlayer())
				return "A swirling vortex of arcane ice has surrounded you, granting you a considerable boost to your cold resistance."
						+ " The arcane ice shards radiate a soothing energy, helping to mitigate any willpower-draining attacks directed your way.";
			else
				return UtilText.genderParsing(target, "A swirling vortex of arcane ice has surrounded " + target.getName("the") + ", granting <herPro> a considerable boost to <her> cold resistance."
						+ " The arcane ice shards radiate a soothing energy, helping to mitigate any willpower-draining attacks directed <her> way.");
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return false;
		}
		
		@Override
		public boolean isCombatEffect() {
			return true;
		}
	},
	POISON_SHIELD(
			10,
			"poison shield",
			"positiveCombatEffect",
			Colour.DAMAGE_TYPE_POISON,
			true,
			Util.newHashMapOfValues(new Value<Attribute, Float>(Attribute.RESISTANCE_POISON, 50f), new Value<Attribute, Float>(Attribute.RESISTANCE_STAMINA, 15f)),
			null) {
		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			if (target.isPlayer())
				return "A swirling vortex of toxic miasma has surrounded you, granting you a considerable boost to your poison resistance." + " The toxic energy helps to mitigate any stamina-draining attacks directed your way.";
			else
				return UtilText.genderParsing(target, "A swirling vortex of toxic miasma has surrounded " + target.getName("the")
						+ ", granting <herPro> a considerable boost to <her> poison resistance." + " The toxic energy helps to mitigate any stamina-draining attacks directed <her> way.");
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return false;
		}
		
		@Override
		public boolean isCombatEffect() {
			return true;
		}
	},
	
	// SEX EFFECTS:
	
	CONDOM_WORN(
			80,
			"Wearing a condom",
			"condom",
			Colour.CLOTHING_PINK_LIGHT,
			false,
			null,
			null) {
		
		@Override
		public float getArousalPerTurnSelf(GameCharacter target) {
			return -0.5f;
		}
		
		@Override
		public List<String> getModifiersAsStringList(GameCharacter target) {
			modifiersList.clear();
			
			modifiersList.add("-0.5% <b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>arousal/turn</b>");
					
			return modifiersList;
		}

		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}

		@Override
		public String getDescription(GameCharacter target) {
			if(target.isPlayer())
				return "Because you're wearing a condom, sex doesn't feel quite as good...";
			else
				return "Because [npc.she]'s wearing a condom, sex doesn't feel quite as good for [npc.name]...";
		}
		
		@Override
		public String extraRemovalEffects(GameCharacter target) {
			return "";
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			return target.isWearingCondom();
		}
		
		@Override
		public boolean isSexEffect() {
			return true;
		}
	},
	
	ANUS_STATUS(
			96,
			"Ass status",
			null,
			Colour.GENERIC_SEX,
			false,
			null,
			null) {

		@Override
		public float getArousalPerTurnSelf(GameCharacter target) {
			float arousal = 0;
			
			if(target.isPlayer()) {
				if(Sex.getPenetrationTypeInOrifice(OrificeType.ANUS_PLAYER) != null) {
					arousal+=2;
					
					if(Sex.getAreasCurrentlyStretchingPlayer().contains(OrificeType.ANUS_PLAYER)) {
						arousal-=0.5;
					}
					if(Sex.getAreasTooLoosePlayer().contains(OrificeType.ANUS_PLAYER)) {
						arousal-=0.5;
					}
					
					if(Sex.getWetOrificeTypes().get(OrificeType.ANUS_PLAYER).isEmpty()) {
						arousal-=1;
					}
				}
			} else {
				if(Sex.getPenetrationTypeInOrifice(OrificeType.ANUS_PARTNER) != null) {
					arousal+=2;
					
					if(Sex.getAreasCurrentlyStretchingPartner().contains(OrificeType.ANUS_PARTNER)) {
						arousal-=0.5;
					}
					if(Sex.getAreasTooLoosePartner().contains(OrificeType.ANUS_PARTNER)) {
						arousal-=0.5;
					}
					
					if(Sex.getWetOrificeTypes().get(OrificeType.ANUS_PARTNER).isEmpty()) {
						arousal-=1;
					}
				}
			}
			
			return arousal;
		}
		
		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}
		
		@Override
		public List<String> getModifiersAsStringList(GameCharacter target) {
			modifiersList.clear();
			
			if(target.isPlayer()) {
				
				if(Sex.getPenetrationTypeInOrifice(OrificeType.ANUS_PLAYER) != null) {
					modifiersList.add("+2 <b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>arousal/turn</b> (<b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>Sex</b>)");
					
					if(Sex.getAreasCurrentlyStretchingPlayer().contains(OrificeType.ANUS_PLAYER)) {
						modifiersList.add("-0.5 <b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>arousal/turn</b> (<b style='color: " + Colour.GENERIC_BAD.toWebHexString() + "'>Stretching</b>)");
					}
					if(Sex.getAreasTooLoosePlayer().contains(OrificeType.ANUS_PLAYER)) {
						modifiersList.add("-0.5 <b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>arousal/turn</b> (<b style='color: " + Colour.GENERIC_BAD.toWebHexString() + "'>Too loose</b>)");
					}
					if(Sex.getWetOrificeTypes().get(OrificeType.ANUS_PLAYER).isEmpty()) {
						modifiersList.add("-1 <b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>arousal/turn</b> (<b style='color: " + Colour.GENERIC_BAD.toWebHexString() + "'>Dry</b>)");
					}
				}
				
			} else {
				
				if(Sex.getPenetrationTypeInOrifice(OrificeType.ANUS_PARTNER) != null) {
					modifiersList.add("+2 <b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>arousal/turn</b> (<b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>Sex</b>)");
					
					if(Sex.getAreasCurrentlyStretchingPartner().contains(OrificeType.ANUS_PARTNER)) {
						modifiersList.add("-0.5 <b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>arousal/turn</b> (<b style='color: " + Colour.GENERIC_BAD.toWebHexString() + "'>Stretching</b>)");
					}
					if(Sex.getAreasTooLoosePartner().contains(OrificeType.ANUS_PARTNER)) {
						modifiersList.add("-0.5 <b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>arousal/turn</b> (<b style='color: " + Colour.GENERIC_BAD.toWebHexString() + "'>Too loose</b>)");
					}
					if(Sex.getWetOrificeTypes().get(OrificeType.ANUS_PARTNER).isEmpty()) {
						modifiersList.add("-1 <b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>arousal/turn</b> (<b style='color: " + Colour.GENERIC_BAD.toWebHexString() + "'>Dry</b>)");
						
					}
				}
			}
			
			return modifiersList;
		}

		@Override
		public String getDescription(GameCharacter target) {
			descriptionSB = new StringBuilder();
			
			if(target.isPlayer()) {
				descriptionSB.append("<p style='text-align:center;margin-top:0;'>");
				
				if(Sex.getPenetrationTypeInOrifice(OrificeType.ANUS_PLAYER) != null) {
					switch(Sex.getPenetrationTypeInOrifice(OrificeType.ANUS_PLAYER)){
						case FINGER_PLAYER:
							descriptionSB.append("You are <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>fingering</b> your own [pc.asshole]!");
							break;
						case FINGER_PARTNER:
							descriptionSB.append("[npc.Name] is <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>fingering</b> your [pc.asshole]!");
							break;
							
						case PENIS_PLAYER:
							descriptionSB.append("You are <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>fucking</b> your own [pc.asshole]!");
							break;
						case PENIS_PARTNER:
							descriptionSB.append("[npc.Name] is <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>fucking</b> your [pc.asshole]!");
							break;
							
						case TAIL_PARTNER:
							descriptionSB.append("[npc.Name] is <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>tail-fucking</b> your [pc.asshole]!");
							break;
						case TAIL_PLAYER:
							descriptionSB.append("You are <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>tail-fucking</b> your own [pc.asshole]!");
							break;
							
						case TONGUE_PLAYER:
							descriptionSB.append("You are performing <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>autoanilingus</b>!");
							break;
						case TONGUE_PARTNER:
							descriptionSB.append("[npc.Name] is performing <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>anilingus</b> on you!");
							break;
						default:
							descriptionSB.append("<b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>Penetrated.</b>");
							break;
					}
				} else {
					descriptionSB.append("<b style='color:"+Colour.TEXT_GREY.toWebHexString()+";'>No penetration.</b>");
				}
				
				if(Sex.getAreasCurrentlyStretchingPlayer().contains(OrificeType.ANUS_PLAYER)) {
					descriptionSB.append("</br>Your [pc.asshole] is being <b style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>stretched</b>!");
					
				} else if(Sex.getAreasTooLoosePlayer().contains(OrificeType.ANUS_PLAYER)) {
					descriptionSB.append("</br>Your [pc.asshole] is <b style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>too loose</b>!");
					
				} else {
					descriptionSB.append("</br><b style='color:"+Colour.TEXT_GREY.toWebHexString()+";'>No stretch effect.</b>");
				}
				
				
				if(Sex.getWetOrificeTypes().get(OrificeType.ANUS_PLAYER).isEmpty()) {
					descriptionSB.append("</br>Your [pc.asshole] is <b style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>dry</b>!");
					
				} else {
					descriptionSB.append("</br>Your [pc.asshole] has been <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>lubricated</b> by:</br>");
					int i=0;
					for(LubricationType lt : Sex.getWetOrificeTypes().get(OrificeType.ANUS_PLAYER)) {
						if(i!=0) {
							if(i == Sex.getWetOrificeTypes().get(OrificeType.ANUS_PLAYER).size()-1) {
								descriptionSB.append(", and ");
							} else {
								descriptionSB.append(", ");
							}
						}
						
						if(i==0)
							descriptionSB.append(Util.capitaliseSentence(lt.getName()));
						else
							descriptionSB.append(lt.getName());
						
						if(i == Sex.getWetOrificeTypes().get(OrificeType.ANUS_PLAYER).size()-1) {
							descriptionSB.append(".");
						}
						
						i++;
					}
				}
				descriptionSB.append("</p>");
				
			} else {
				descriptionSB.append("<p style='text-align:center;margin-top:0;'>");
				
				if(Sex.getPenetrationTypeInOrifice(OrificeType.ANUS_PARTNER) != null) {
					switch(Sex.getPenetrationTypeInOrifice(OrificeType.ANUS_PARTNER)){
						case FINGER_PLAYER:
							descriptionSB.append("You are <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>fingering</b> [npc.name]'s [npc.asshole]!");
							break;
						case FINGER_PARTNER:
							descriptionSB.append(UtilText.genderParsing(Sex.getPartner(),
									"[npc.Name] is <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>fingering</b> <her> own [npc.asshole]!"));
							break;
							
						case PENIS_PARTNER:
							descriptionSB.append(UtilText.genderParsing(Sex.getPartner(),
									"[npc.Name] is <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>fucking</b> <her> own [npc.asshole]!"));
							break;
						case PENIS_PLAYER:
							descriptionSB.append("You are <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>fucking</b> [npc.name]'s [npc.asshole]!");
							break;
							
						case TAIL_PLAYER:
							descriptionSB.append("You are <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>tail-fucking</b> [npc.name]'s [npc.asshole]!");
							break;
						case TAIL_PARTNER:
							descriptionSB.append(UtilText.genderParsing(Sex.getPartner(),
									"[npc.Name] is <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>tail-fucking</b> <her> own [npc.asshole]!"));
							break;
							
						case TONGUE_PARTNER:
							descriptionSB.append("[npc.Name] is performing <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>autoanilingus</b>!");
							break;
						case TONGUE_PLAYER:
							descriptionSB.append("You are performing <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>anilingus</b> on [npc.name]!");
							break;
						default:
							descriptionSB.append("<b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>Penetrated.</b>");
							break;
					}
				} else {
					descriptionSB.append("<b style='color:"+Colour.TEXT_GREY.toWebHexString()+";'>No penetration.</b>");
				}
				
				if(Sex.getAreasCurrentlyStretchingPartner().contains(OrificeType.ANUS_PARTNER)) {
					descriptionSB.append("</br>[npc.Name]'s [npc.asshole] is being <b style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>stretched</b>!");
					
				} else if(Sex.getAreasTooLoosePartner().contains(OrificeType.ANUS_PARTNER)) {
					descriptionSB.append("</br>[npc.Name]'s [npc.asshole] is <b style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>too loose</b>!");
				} else {
					descriptionSB.append("</br><b style='color:"+Colour.TEXT_GREY.toWebHexString()+";'>No stretch effect.</b>");
				}
				
				
				if(Sex.getWetOrificeTypes().get(OrificeType.ANUS_PARTNER).isEmpty()) {
					descriptionSB.append("</br>[npc.Name]'s [npc.asshole] is <b style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>dry</b>!");
					
				} else {
					descriptionSB.append("</br>[npc.Name]'s [npc.asshole] has been <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>lubricated</b> by:</br>");
					int i=0;
					for(LubricationType lt : Sex.getWetOrificeTypes().get(OrificeType.ANUS_PARTNER)) {
						if(i!=0) {
							if(i == Sex.getWetOrificeTypes().get(OrificeType.ANUS_PARTNER).size()-1) {
								descriptionSB.append(", and ");
							} else {
								descriptionSB.append(", ");
							}
						}
						
						if(i==0)
							descriptionSB.append(Util.capitaliseSentence(lt.getName()));
						else
							descriptionSB.append(lt.getName());
						
						if(i == Sex.getWetOrificeTypes().get(OrificeType.ANUS_PARTNER).size()-1) {
							descriptionSB.append(".");
						}
						
						i++;
					}
				}
				descriptionSB.append("</p>");
			}
			
			
			return descriptionSB.toString();
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			if(Main.game.isInSex()) {
				return true;
				
			} else {
				return false;
			}
		}
		
		@Override
		public boolean isSexEffect() {
			return true;
		}
		
		@Override
		public String getSVGString(GameCharacter owner) {
			SVGImageSB = new StringBuilder();
			
			SVGImageSB.append(SVGImages.SVG_IMAGE_PROVIDER.getCoverableAreaAnus());
			
			if(owner.isPlayer()) {
				if(Sex.getPenetrationTypeInOrifice(OrificeType.ANUS_PLAYER) != null) {
					switch(Sex.getPenetrationTypeInOrifice(OrificeType.ANUS_PLAYER)){
						case FINGER_PLAYER: case FINGER_PARTNER:
							SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getPenetrationTypeFinger()+"</div>");
							break;
						case PENIS_PLAYER: case PENIS_PARTNER:
							SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getPenetrationTypePenis()+"</div>");
							break;
						case TAIL_PLAYER: case TAIL_PARTNER:
							SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getPenetrationTypeTail()+"</div>");
							break;
						case TONGUE_PLAYER: case TONGUE_PARTNER:
							SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getPenetrationTypeTongue()+"</div>");
							break;
						default:
							break;
					}
				}
				
				if(Sex.getAreasCurrentlyStretchingPlayer().contains(OrificeType.ANUS_PLAYER)) {
					SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getCombinationStretching()+"</div>");
				}
				
				if(Sex.getAreasTooLoosePlayer().contains(OrificeType.ANUS_PLAYER)) {
					SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getCombinationTooLoose()+"</div>");
				}
				
				if(Sex.getWetOrificeTypes().get(OrificeType.ANUS_PLAYER).isEmpty()) {
					SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getCombinationDry()+"</div>");
				} else {
					SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getCombinationWet()+"</div>");
				}
				
			} else {
				if(Sex.getPenetrationTypeInOrifice(OrificeType.ANUS_PARTNER) != null) {
					switch(Sex.getPenetrationTypeInOrifice(OrificeType.ANUS_PARTNER)){
						case FINGER_PLAYER: case FINGER_PARTNER:
							SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getPenetrationTypeFinger()+"</div>");
							break;
						case PENIS_PLAYER: case PENIS_PARTNER:
							SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getPenetrationTypePenis()+"</div>");
							break;
						case TAIL_PLAYER: case TAIL_PARTNER:
							SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getPenetrationTypeTail()+"</div>");
							break;
						case TONGUE_PLAYER: case TONGUE_PARTNER:
							SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getPenetrationTypeTongue()+"</div>");
							break;
						default:
							break;
					}
				}

				if(Sex.getAreasCurrentlyStretchingPartner().contains(OrificeType.ANUS_PARTNER)) {
					SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getCombinationStretching()+"</div>");
				}
				
				if(Sex.getAreasTooLoosePartner().contains(OrificeType.ANUS_PARTNER)) {
					SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getCombinationTooLoose()+"</div>");
				}
				
				if(Sex.getWetOrificeTypes().get(OrificeType.ANUS_PARTNER).isEmpty()) {
					SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getCombinationDry()+"</div>");
				} else {
					SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getCombinationWet()+"</div>");
				}
			}
			
			return SVGImageSB.toString();
		}
	},
	
	MOUTH_STATUS(
			99,
			"Mouth status",
			null,
			Colour.GENERIC_SEX,
			false,
			null,
			null) {
		
		@Override
		public float getArousalPerTurnSelf(GameCharacter target) {
			float arousal = 0;
			
			if(target.isPlayer()) {
				if(Sex.getPenetrationTypeInOrifice(OrificeType.MOUTH_PLAYER) != null) {
					arousal+=1;
					
					if(Sex.getAreasCurrentlyStretchingPlayer().contains(OrificeType.MOUTH_PLAYER)) {
						arousal-=0.5;
					}
					if(Sex.getAreasTooLoosePlayer().contains(OrificeType.MOUTH_PLAYER)) {
						arousal-=0.5;
					}
				}
			} else {
				if(Sex.getPenetrationTypeInOrifice(OrificeType.MOUTH_PARTNER) != null) {
					arousal+=1;
					
					if(Sex.getAreasCurrentlyStretchingPartner().contains(OrificeType.MOUTH_PARTNER)) {
						arousal-=0.5;
					}
					if(Sex.getAreasTooLoosePartner().contains(OrificeType.MOUTH_PARTNER)) {
						arousal-=0.5;
					}
				}
			}
			
			return arousal;
		}
		
		
		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}
		
		@Override
		public List<String> getModifiersAsStringList(GameCharacter target) {
			modifiersList.clear();
			
			if(target.isPlayer()) {
				
				if(Sex.getPenetrationTypeInOrifice(OrificeType.MOUTH_PLAYER) != null) {
					modifiersList.add("+1 <b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>arousal/turn</b> (<b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>Sex</b>)");
					
					if(Sex.getAreasCurrentlyStretchingPlayer().contains(OrificeType.MOUTH_PLAYER)) {
						modifiersList.add("-0.5 <b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>arousal/turn</b> (<b style='color: " + Colour.GENERIC_BAD.toWebHexString() + "'>Stretching</b>)");
					}
					
					if(Sex.getAreasTooLoosePlayer().contains(OrificeType.MOUTH_PLAYER)) {
						modifiersList.add("-0.5 <b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>arousal/turn</b> (<b style='color: " + Colour.GENERIC_BAD.toWebHexString() + "'>Too loose</b>)");
					}
				}
				
			} else {
				
				if(Sex.getPenetrationTypeInOrifice(OrificeType.MOUTH_PARTNER) != null) {
					modifiersList.add("+1 <b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>arousal/turn</b> (<b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>Sex</b>)");
					
					if(Sex.getAreasCurrentlyStretchingPartner().contains(OrificeType.MOUTH_PARTNER)) {
						modifiersList.add("-0.5 <b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>arousal/turn</b> (<b style='color: " + Colour.GENERIC_BAD.toWebHexString() + "'>Stretching</b>)");
					}
					
					if(Sex.getAreasTooLoosePartner().contains(OrificeType.MOUTH_PARTNER)) {
						modifiersList.add("-0.5 <b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>arousal/turn</b> (<b style='color: " + Colour.GENERIC_BAD.toWebHexString() + "'>Too loose</b>)");
					}
				}
				
			}
			
			return modifiersList;
		}

		@Override
		public String getDescription(GameCharacter target) {
			descriptionSB = new StringBuilder();
			
			if(target.isPlayer()) {
				descriptionSB.append("<p style='text-align:center;margin-top:0;'>");
				
				if(Sex.getPenetrationTypeInOrifice(OrificeType.MOUTH_PLAYER) != null) {
					switch(Sex.getPenetrationTypeInOrifice(OrificeType.MOUTH_PLAYER)){
						case FINGER_PLAYER:
							descriptionSB.append("You are <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>sucking your fingers</b>!");
							break;
						case FINGER_PARTNER:
							descriptionSB.append("You are <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>sucking [npc.name]'s fingers</b>!");
							break;
							
						case PENIS_PARTNER:
							descriptionSB.append("You are <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>sucking [npc.name]'s "+Sex.getPartner().getPenisName(true)+"</b>!");
							break;
						case PENIS_PLAYER:
							descriptionSB.append("You are <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>sucking your own "+Main.game.getPlayer().getPenisName(true)+"</b>!");
							break;
							
						case TAIL_PARTNER:
							descriptionSB.append("You are <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>sucking [npc.name]'s tail</b>!");
							break;
						case TAIL_PLAYER:
							descriptionSB.append("You are <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>sucking your tail</b>!");
							break;
							
						case TONGUE_PARTNER:
							descriptionSB.append(UtilText.genderParsing(Sex.getPartner(),
									"[npc.Name]'s tongue is <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>fucking <her> own throat</b>!"));
							break;
						case TONGUE_PLAYER:
							descriptionSB.append("[npc.Name] is <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>snogging</b> you!");
							break;
						default:
							descriptionSB.append("<b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>Penetrated.</b>");
							break;
					}
				} else {
					descriptionSB.append("<b style='color:"+Colour.TEXT_GREY.toWebHexString()+";'>No penetration.</b>");
				}
				
				if(Sex.getAreasCurrentlyStretchingPlayer().contains(OrificeType.MOUTH_PLAYER)) {
					descriptionSB.append("</br>Your throat is being <b style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>stretched</b>!");
					
				} else if(Sex.getAreasTooLoosePlayer().contains(OrificeType.MOUTH_PLAYER)) {
					descriptionSB.append("</br>Your throat is <b style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>too loose</b>!");
				} else {
					descriptionSB.append("</br><b style='color:"+Colour.TEXT_GREY.toWebHexString()+";'>No stretch effect.</b>");
				}
				
				
				if(Sex.getWetOrificeTypes().get(OrificeType.MOUTH_PLAYER).isEmpty()) {
					descriptionSB.append("</br>Your throat is <b style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>dry</b>!");
					
				} else {
					descriptionSB.append("</br>Your throat has been <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>lubricated</b> by:</br>");
					int i=0;
					for(LubricationType lt : Sex.getWetOrificeTypes().get(OrificeType.MOUTH_PLAYER)) {
						if(i!=0) {
							if(i == Sex.getWetOrificeTypes().get(OrificeType.MOUTH_PLAYER).size()-1) {
								descriptionSB.append(", and ");
							} else {
								descriptionSB.append(", ");
							}
						}
						
						if(i==0)
							descriptionSB.append(Util.capitaliseSentence(lt.getName()));
						else
							descriptionSB.append(lt.getName());
						
						if(i == Sex.getWetOrificeTypes().get(OrificeType.MOUTH_PLAYER).size()-1) {
							descriptionSB.append(".");
						}
						
						i++;
					}
				}
				descriptionSB.append("</p>");
				
			} else {
				descriptionSB.append("<p style='text-align:center;margin-top:0;'>");
				
				if(Sex.getPenetrationTypeInOrifice(OrificeType.MOUTH_PARTNER) != null) {
					switch(Sex.getPenetrationTypeInOrifice(OrificeType.MOUTH_PARTNER)){
						case FINGER_PLAYER:
							descriptionSB.append("[npc.Name] is <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>sucking your fingers</b>!");
							break;
						case FINGER_PARTNER:
							descriptionSB.append(UtilText.genderParsing(Sex.getPartner(),
									"[npc.Name] is <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>sucking <her> own fingers</b>!"));
							break;
							
						case PENIS_PARTNER:
							descriptionSB.append(UtilText.genderParsing(Sex.getPartner(),
									"[npc.Name] is <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>sucking<her> own "+Sex.getPartner().getPenisName(true)+"</b> !"));
							break;
						case PENIS_PLAYER:
							descriptionSB.append("[npc.Name] is <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>sucking your "+Main.game.getPlayer().getPenisName(true)+"</b>!");
							break;
							
						case TAIL_PLAYER:
							descriptionSB.append("[npc.Name] is <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>sucking your tail</b>!");
							break;
						case TAIL_PARTNER:
							descriptionSB.append(UtilText.genderParsing(Sex.getPartner(),
									"[npc.Name] is <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>sucking <her> own tail</b>!"));
							break;
							
						case TONGUE_PLAYER:
							descriptionSB.append("You are <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>snogging</b> [npc.name]!");
							break;
						case TONGUE_PARTNER:
							descriptionSB.append("[npc.Name] is <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>kissing herself</b>?");
							break;
						default:
							descriptionSB.append("<b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>Penetrated.</b>");
							break;
					}
				} else {
					descriptionSB.append("<b style='color:"+Colour.TEXT_GREY.toWebHexString()+";'>No penetration.</b>");
				}
				
				if(Sex.getAreasCurrentlyStretchingPartner().contains(OrificeType.MOUTH_PARTNER)) {
					descriptionSB.append("</br>[npc.Name]'s throat is being <b style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>stretched</b>!");
					
				} else if(Sex.getAreasTooLoosePartner().contains(OrificeType.MOUTH_PARTNER)) {
					descriptionSB.append("</br>[npc.Name]'s throat is <b style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>too loose</b>!");
				} else {
					descriptionSB.append("</br><b style='color:"+Colour.TEXT_GREY.toWebHexString()+";'>No stretch effect.</b>");
				}
				
				
				if(Sex.getWetOrificeTypes().get(OrificeType.MOUTH_PARTNER).isEmpty()) {
					descriptionSB.append("</br>[npc.Name]'s throat is <b style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>dry</b>!");
					
				} else {
					descriptionSB.append("</br>[npc.Name]'s throat has been <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>lubricated</b> by:</br>");
					int i=0;
					for(LubricationType lt : Sex.getWetOrificeTypes().get(OrificeType.MOUTH_PARTNER)) {
						if(i!=0) {
							if(i == Sex.getWetOrificeTypes().get(OrificeType.MOUTH_PARTNER).size()-1) {
								descriptionSB.append(", and ");
							} else {
								descriptionSB.append(", ");
							}
						}
						
						if(i==0)
							descriptionSB.append(Util.capitaliseSentence(lt.getName()));
						else
							descriptionSB.append(lt.getName());
						
						if(i == Sex.getWetOrificeTypes().get(OrificeType.MOUTH_PARTNER).size()-1) {
							descriptionSB.append(".");
						}
						
						i++;
					}
				}
				descriptionSB.append("</p>");
			}
			
			
			return descriptionSB.toString();
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			if(Main.game.isInSex()) {
				return true;
				
			} else {
				return false;
			}
		}
		
		@Override
		public boolean isSexEffect() {
			return true;
		}
		
		@Override
		public String getSVGString(GameCharacter owner) {
			SVGImageSB = new StringBuilder();
			
			SVGImageSB.append(SVGImages.SVG_IMAGE_PROVIDER.getCoverableAreaMouth());
			
			if(owner.isPlayer()) {
				if(Sex.getPenetrationTypeInOrifice(OrificeType.MOUTH_PLAYER) != null) {
					switch(Sex.getPenetrationTypeInOrifice(OrificeType.MOUTH_PLAYER)){
						case FINGER_PLAYER: case FINGER_PARTNER:
							SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getPenetrationTypeFinger()+"</div>");
							break;
						case PENIS_PLAYER: case PENIS_PARTNER:
							SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getPenetrationTypePenis()+"</div>");
							break;
						case TAIL_PLAYER: case TAIL_PARTNER:
							SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getPenetrationTypeTail()+"</div>");
							break;
						case TONGUE_PLAYER: case TONGUE_PARTNER:
							SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getPenetrationTypeTongue()+"</div>");
							break;
						default:
							break;
					}
				}
				
				if(Sex.getAreasCurrentlyStretchingPlayer().contains(OrificeType.MOUTH_PLAYER)) {
					SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getCombinationStretching()+"</div>");
				}
				
				if(Sex.getAreasTooLoosePlayer().contains(OrificeType.MOUTH_PLAYER)) {
					SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getCombinationTooLoose()+"</div>");
				}
				
				if(Sex.getWetOrificeTypes().get(OrificeType.MOUTH_PLAYER).isEmpty()) {
					SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getCombinationDry()+"</div>");
				} else {
					SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getCombinationWet()+"</div>");
				}
				
			} else {
				if(Sex.getPenetrationTypeInOrifice(OrificeType.MOUTH_PARTNER) != null) {
					switch(Sex.getPenetrationTypeInOrifice(OrificeType.MOUTH_PARTNER)){
						case FINGER_PLAYER: case FINGER_PARTNER:
							SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getPenetrationTypeFinger()+"</div>");
							break;
						case PENIS_PLAYER: case PENIS_PARTNER:
							SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getPenetrationTypePenis()+"</div>");
							break;
						case TAIL_PLAYER: case TAIL_PARTNER:
							SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getPenetrationTypeTail()+"</div>");
							break;
						case TONGUE_PLAYER: case TONGUE_PARTNER:
							SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getPenetrationTypeTongue()+"</div>");
							break;
						default:
							break;
					}
				}

				if(Sex.getAreasCurrentlyStretchingPartner().contains(OrificeType.MOUTH_PARTNER)) {
					SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getCombinationStretching()+"</div>");
				}
				
				if(Sex.getAreasTooLoosePartner().contains(OrificeType.MOUTH_PARTNER)) {
					SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getCombinationTooLoose()+"</div>");
				}
				
				if(Sex.getWetOrificeTypes().get(OrificeType.MOUTH_PARTNER).isEmpty()) {
					SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getCombinationDry()+"</div>");
				} else {
					SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getCombinationWet()+"</div>");
				}
			}
			
			return SVGImageSB.toString();
		}
	},
	NIPPLE_STATUS(
			98,
			"Nipple status",
			null,
			Colour.GENERIC_SEX,
			false,
			null,
			null) {

		@Override
		public float getArousalPerTurnSelf(GameCharacter target) {
			float arousal = 0;
			
			if(target.isPlayer()) {
				if(Sex.getPenetrationTypeInOrifice(OrificeType.NIPPLE_PLAYER) != null) {
					arousal+=2;
					
					if(Sex.getAreasCurrentlyStretchingPlayer().contains(OrificeType.NIPPLE_PLAYER)) {
						arousal-=0.5;
					}
					if(Sex.getAreasTooLoosePlayer().contains(OrificeType.NIPPLE_PLAYER)) {
						arousal-=0.5;
					}
					if(Sex.getWetOrificeTypes().get(OrificeType.NIPPLE_PLAYER).isEmpty()) {
						arousal-=1;
					} 
				}
			} else {
				if(Sex.getPenetrationTypeInOrifice(OrificeType.NIPPLE_PARTNER) != null) {
					arousal+=2;
					
					if(Sex.getAreasCurrentlyStretchingPartner().contains(OrificeType.NIPPLE_PARTNER)) {
						arousal-=0.5;
					}
					if(Sex.getAreasTooLoosePartner().contains(OrificeType.NIPPLE_PARTNER)) {
						arousal-=0.5;
					}
					if(Sex.getWetOrificeTypes().get(OrificeType.NIPPLE_PARTNER).isEmpty()) {
						arousal-=1;
					} 
				}
			}
			
			return arousal;
		}
		
		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}
		
		@Override
		public List<String> getModifiersAsStringList(GameCharacter target) {
			modifiersList.clear();
			
			if(target.isPlayer()) {
				
				if(Sex.getPenetrationTypeInOrifice(OrificeType.NIPPLE_PLAYER) != null) {
					modifiersList.add("+2 <b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>arousal/turn</b> (<b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>Sex</b>)");
					
					if(Sex.getAreasCurrentlyStretchingPlayer().contains(OrificeType.NIPPLE_PLAYER)) {
						modifiersList.add("-0.5 <b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>arousal/turn</b> (<b style='color: " + Colour.GENERIC_BAD.toWebHexString() + "'>Stretching</b>)");
					}
					
					if(Sex.getAreasTooLoosePlayer().contains(OrificeType.NIPPLE_PLAYER)) {
						modifiersList.add("-0.5 <b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>arousal/turn</b> (<b style='color: " + Colour.GENERIC_BAD.toWebHexString() + "'>Too loose</b>)");
					}
					
					if(Sex.getWetOrificeTypes().get(OrificeType.NIPPLE_PLAYER).isEmpty()) {
						modifiersList.add("-1 <b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>arousal/turn</b> (<b style='color: " + Colour.GENERIC_BAD.toWebHexString() + "'>Dry</b>)");
						
					}
				}
				
			} else {
				
				if(Sex.getPenetrationTypeInOrifice(OrificeType.NIPPLE_PARTNER) != null) {
					modifiersList.add("+2 <b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>arousal/turn</b> (<b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>Sex</b>)");
					
					if(Sex.getAreasCurrentlyStretchingPartner().contains(OrificeType.NIPPLE_PARTNER)) {
						modifiersList.add("-0.5 <b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>arousal/turn</b> (<b style='color: " + Colour.GENERIC_BAD.toWebHexString() + "'>Stretching</b>)");
					}
					
					if(Sex.getAreasTooLoosePartner().contains(OrificeType.NIPPLE_PARTNER)) {
						modifiersList.add("-0.5 <b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>arousal/turn</b> (<b style='color: " + Colour.GENERIC_BAD.toWebHexString() + "'>Too loose</b>)");
					}
					
					if(Sex.getWetOrificeTypes().get(OrificeType.NIPPLE_PARTNER).isEmpty()) {
						modifiersList.add("-1 <b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>arousal/turn</b> (<b style='color: " + Colour.GENERIC_BAD.toWebHexString() + "'>Dry</b>)");
						
					}
				}
			}
			
			return modifiersList;
		}

		@Override
		public String getDescription(GameCharacter target) {
			descriptionSB = new StringBuilder();
			
			if(target.isPlayer()) {
				descriptionSB.append("<p style='text-align:center;margin-top:0;'>");
				
				if(Sex.getPenetrationTypeInOrifice(OrificeType.NIPPLE_PLAYER) != null) {
					switch(Sex.getPenetrationTypeInOrifice(OrificeType.NIPPLE_PLAYER)){
						case FINGER_PLAYER:
							descriptionSB.append("You are <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>fingering</b> your own [pc.nipple]!");
							break;
						case FINGER_PARTNER:
							descriptionSB.append("[npc.Name] is <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>fingering</b> your [pc.nipple]!");
							break;
							
						case PENIS_PLAYER:
							descriptionSB.append("You are <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>fucking</b> your own [pc.nipple]!");
							break;
						case PENIS_PARTNER:
							descriptionSB.append("[npc.Name] is <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>fucking</b> your [pc.nipple]!");
							break;
							
						case TAIL_PARTNER:
							descriptionSB.append("[npc.Name] is <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>tail-fucking</b> your [pc.nipple]!");
							break;
						case TAIL_PLAYER:
							descriptionSB.append("You are <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>tail-fucking</b> your own [pc.nipple]!");
							break;
							
						case TONGUE_PLAYER:
							descriptionSB.append("You are <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>eating out</b> your [pc.nipple]!");
							break;
						case TONGUE_PARTNER:
							descriptionSB.append("[npc.Name] is <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>eating out</b> your [pc.nipple]!");
							break;
						default:
							descriptionSB.append("<b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>Penetrated.</b>");
							break;
					}
				} else {
					descriptionSB.append("<b style='color:"+Colour.TEXT_GREY.toWebHexString()+";'>No penetration.</b>");
				}
				
				if(Sex.getAreasCurrentlyStretchingPlayer().contains(OrificeType.NIPPLE_PLAYER)) {
					descriptionSB.append("</br>Your [pc.nipple] are being <b style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>stretched</b>!");
					
				} else if(Sex.getAreasTooLoosePlayer().contains(OrificeType.NIPPLE_PLAYER)) {
					descriptionSB.append("</br>Your [pc.nipple] are <b style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>too loose</b>!");
				} else {
					descriptionSB.append("</br><b style='color:"+Colour.TEXT_GREY.toWebHexString()+";'>No stretch effect.</b>");
				}
				
				
				if(Sex.getWetOrificeTypes().get(OrificeType.NIPPLE_PLAYER).isEmpty()) {
					descriptionSB.append("</br>Your [pc.nipple] are <b style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>dry</b>!");
					
				} else {
					descriptionSB.append("</br>Your [pc.nipple] have been <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>lubricated</b> by:</br>");
					int i=0;
					for(LubricationType lt : Sex.getWetOrificeTypes().get(OrificeType.NIPPLE_PLAYER)) {
						if(i!=0) {
							if(i == Sex.getWetOrificeTypes().get(OrificeType.NIPPLE_PLAYER).size()-1) {
								descriptionSB.append(", and ");
							} else {
								descriptionSB.append(", ");
							}
						}
						
						if(i==0)
							descriptionSB.append(Util.capitaliseSentence(lt.getName()));
						else
							descriptionSB.append(lt.getName());
						
						if(i == Sex.getWetOrificeTypes().get(OrificeType.NIPPLE_PLAYER).size()-1) {
							descriptionSB.append(".");
						}
						
						i++;
					}
				}
				descriptionSB.append("</p>");
				
			} else {
				descriptionSB.append("<p style='text-align:center;margin-top:0;'>");
				
				if(Sex.getPenetrationTypeInOrifice(OrificeType.NIPPLE_PARTNER) != null) {
					switch(Sex.getPenetrationTypeInOrifice(OrificeType.NIPPLE_PARTNER)){
						case FINGER_PLAYER:
							descriptionSB.append("You are <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>fingering</b> [npc.name]'s "+Sex.getPartner().getNippleName(true)+"!");
							break;
						case FINGER_PARTNER:
							descriptionSB.append(UtilText.genderParsing(Sex.getPartner(),
									"[npc.Name] is <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>fingering</b> <her> own "+Sex.getPartner().getNippleName(true)+"!"));
							break;
							
						case PENIS_PARTNER:
							descriptionSB.append(UtilText.genderParsing(Sex.getPartner(),
									"[npc.Name] is <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>fucking</b> <her> own "+Sex.getPartner().getNippleName(true)+"!"));
							break;
						case PENIS_PLAYER:
							descriptionSB.append("You are <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>fucking</b> [npc.name]'s "+Sex.getPartner().getNippleName(true)+"!");
							break;
							
						case TAIL_PLAYER:
							descriptionSB.append("You are <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>tail-fucking</b> [npc.name]'s "+Sex.getPartner().getNippleName(true)+"!");
							break;
						case TAIL_PARTNER:
							descriptionSB.append(UtilText.genderParsing(Sex.getPartner(),
									"[npc.Name] is <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>tail-fucking <her> own "+Sex.getPartner().getNippleName(true)+"</b>!"));
							break;
							
						case TONGUE_PARTNER:
							descriptionSB.append(UtilText.genderParsing(Sex.getPartner(),
									"[npc.Name]'s is <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>eating out</b> <her> "+Sex.getPartner().getNippleName(true)+"!"));
							break;
						case TONGUE_PLAYER:
							descriptionSB.append("You are <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>eating out</b> [npc.name]'s "+Sex.getPartner().getNippleName(true)+"!");
							break;
						default:
							descriptionSB.append("<b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>Penetrated.</b>");
							break;
					}
				} else {
					descriptionSB.append("<b style='color:"+Colour.TEXT_GREY.toWebHexString()+";'>No penetration.</b>");
				}
				
				if(Sex.getAreasCurrentlyStretchingPartner().contains(OrificeType.NIPPLE_PARTNER)) {
					descriptionSB.append("</br>[npc.Name]'s "+Sex.getPartner().getNippleName(true)+" are being <b style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>stretched</b>!");
					
				} else if(Sex.getAreasTooLoosePartner().contains(OrificeType.NIPPLE_PARTNER)) {
					descriptionSB.append("</br>[npc.Name]'s "+Sex.getPartner().getNippleName(true)+" are <b style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>too loose</b>!");
				} else {
					descriptionSB.append("</br><b style='color:"+Colour.TEXT_GREY.toWebHexString()+";'>No stretch effect.</b>");
				}
				
				
				if(Sex.getWetOrificeTypes().get(OrificeType.NIPPLE_PARTNER).isEmpty()) {
					descriptionSB.append("</br>[npc.Name]'s "+Sex.getPartner().getNippleName(true)+" are <b style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>dry</b>!");
					
				} else {
					descriptionSB.append("</br>[npc.Name]'s "+Sex.getPartner().getNippleName(true)+" have been <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>lubricated</b> by:</br>");
					int i=0;
					for(LubricationType lt : Sex.getWetOrificeTypes().get(OrificeType.NIPPLE_PARTNER)) {
						if(i!=0) {
							if(i == Sex.getWetOrificeTypes().get(OrificeType.NIPPLE_PARTNER).size()-1) {
								descriptionSB.append(", and ");
							} else {
								descriptionSB.append(", ");
							}
						}
						
						if(i==0)
							descriptionSB.append(Util.capitaliseSentence(lt.getName()));
						else
							descriptionSB.append(lt.getName());
						
						if(i == Sex.getWetOrificeTypes().get(OrificeType.NIPPLE_PARTNER).size()-1) {
							descriptionSB.append(".");
						}
						
						i++;
					}
				}
				descriptionSB.append("</p>");
			}
			
			
			return descriptionSB.toString();
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			if(Main.game.isInSex()) {
				if(target.isBreastFuckable())
					return true;
				else
					return false;
				
			} else {
				return false;
			}
		}
		
		@Override
		public boolean isSexEffect() {
			return true;
		}
		
		@Override
		public String getSVGString(GameCharacter owner) {
			SVGImageSB = new StringBuilder();
			
			SVGImageSB.append(SVGImages.SVG_IMAGE_PROVIDER.getCoverableAreaNipple());
			
			if(owner.isPlayer()) {
				if(Sex.getPenetrationTypeInOrifice(OrificeType.NIPPLE_PLAYER) != null) {
					switch(Sex.getPenetrationTypeInOrifice(OrificeType.NIPPLE_PLAYER)){
						case FINGER_PLAYER: case FINGER_PARTNER:
							SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getPenetrationTypeFinger()+"</div>");
							break;
						case PENIS_PLAYER: case PENIS_PARTNER:
							SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getPenetrationTypePenis()+"</div>");
							break;
						case TAIL_PLAYER: case TAIL_PARTNER:
							SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getPenetrationTypeTail()+"</div>");
							break;
						case TONGUE_PLAYER: case TONGUE_PARTNER:
							SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getPenetrationTypeTongue()+"</div>");
							break;
						default:
							break;
					}
				}
				
				if(Sex.getAreasCurrentlyStretchingPlayer().contains(OrificeType.NIPPLE_PLAYER)) {
					SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getCombinationStretching()+"</div>");
				}
				
				if(Sex.getAreasTooLoosePlayer().contains(OrificeType.NIPPLE_PLAYER)) {
					SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getCombinationTooLoose()+"</div>");
				}
				
				if(Sex.getWetOrificeTypes().get(OrificeType.NIPPLE_PLAYER).isEmpty()) {
					SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getCombinationDry()+"</div>");
				} else {
					SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getCombinationWet()+"</div>");
				}
				
			} else {
				if(Sex.getPenetrationTypeInOrifice(OrificeType.NIPPLE_PARTNER) != null) {
					switch(Sex.getPenetrationTypeInOrifice(OrificeType.NIPPLE_PARTNER)){
						case FINGER_PLAYER: case FINGER_PARTNER:
							SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getPenetrationTypeFinger()+"</div>");
							break;
						case PENIS_PLAYER: case PENIS_PARTNER:
							SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getPenetrationTypePenis()+"</div>");
							break;
						case TAIL_PLAYER: case TAIL_PARTNER:
							SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getPenetrationTypeTail()+"</div>");
							break;
						case TONGUE_PLAYER: case TONGUE_PARTNER:
							SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getPenetrationTypeTongue()+"</div>");
							break;
						default:
							break;
					}
				}

				if(Sex.getAreasCurrentlyStretchingPartner().contains(OrificeType.NIPPLE_PARTNER)) {
					SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getCombinationStretching()+"</div>");
				}
				
				if(Sex.getAreasTooLoosePartner().contains(OrificeType.NIPPLE_PARTNER)) {
					SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getCombinationTooLoose()+"</div>");
				}
				
				if(Sex.getWetOrificeTypes().get(OrificeType.NIPPLE_PARTNER).isEmpty()) {
					SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getCombinationDry()+"</div>");
				} else {
					SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getCombinationWet()+"</div>");
				}
			}
			
			return SVGImageSB.toString();
		}
	},
	VAGINA_STATUS(
			95,
			"Pussy status",
			null,
			Colour.GENERIC_SEX,
			false,
			null,
			null) {

		@Override
		public float getArousalPerTurnSelf(GameCharacter target) {
			float arousal = 0;
			
			if(target.isPlayer()) {
				if(Sex.getPenetrationTypeInOrifice(OrificeType.VAGINA_PLAYER) != null) {
					arousal+=4;
					
					if(Sex.getAreasCurrentlyStretchingPlayer().contains(OrificeType.VAGINA_PLAYER)) {
						arousal-=0.5;
					}
					if(Sex.getAreasTooLoosePlayer().contains(OrificeType.VAGINA_PLAYER)) {
						arousal-=0.5;
					}
					if(Sex.getWetOrificeTypes().get(OrificeType.VAGINA_PLAYER).isEmpty()) {
						arousal-=1;
					} 
				}
			} else {
				if(Sex.getPenetrationTypeInOrifice(OrificeType.VAGINA_PARTNER) != null) {
					arousal+=4;
					
					if(Sex.getAreasCurrentlyStretchingPartner().contains(OrificeType.VAGINA_PARTNER)) {
						arousal-=0.5;
					}
					if(Sex.getAreasTooLoosePartner().contains(OrificeType.VAGINA_PARTNER)) {
						arousal-=0.5;
					}
					if(Sex.getWetOrificeTypes().get(OrificeType.VAGINA_PARTNER).isEmpty()) {
						arousal-=1;
					} 
				}
			}
			
			return arousal;
		}
		
		@Override
		public String applyEffect(GameCharacter target, int minutesPassed) {
			return "";
		}
		
		@Override
		public List<String> getModifiersAsStringList(GameCharacter target) {
			modifiersList.clear();
			
			if(target.isPlayer()) {
				
				if(Sex.getPenetrationTypeInOrifice(OrificeType.VAGINA_PLAYER) != null) {
					modifiersList.add("+4 <b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>arousal</b> (<b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>Sex</b>)");
					
					if(Sex.getAreasCurrentlyStretchingPlayer().contains(OrificeType.VAGINA_PLAYER)) {
						modifiersList.add("-0.5 <b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>arousal</b> (<b style='color: " + Colour.GENERIC_BAD.toWebHexString() + "'>Stretching</b>)");
					}
					if(Sex.getAreasTooLoosePlayer().contains(OrificeType.VAGINA_PLAYER)) {
						modifiersList.add("-0.5 <b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>arousal</b> (<b style='color: " + Colour.GENERIC_BAD.toWebHexString() + "'>Too loose</b>)");
					}
					if(Sex.getWetOrificeTypes().get(OrificeType.VAGINA_PLAYER).isEmpty()) {
						modifiersList.add("-1 <b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>arousal</b> (<b style='color: " + Colour.GENERIC_BAD.toWebHexString() + "'>Dry</b>)");
						
					}
				}
				
			} else {
				
				if(Sex.getPenetrationTypeInOrifice(OrificeType.VAGINA_PARTNER) != null) {
					modifiersList.add("+4 <b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>arousal</b> (<b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>Sex</b>)");
					
					if(Sex.getAreasCurrentlyStretchingPartner().contains(OrificeType.VAGINA_PARTNER)) {
						modifiersList.add("-0.5 <b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>arousal</b> (<b style='color: " + Colour.GENERIC_BAD.toWebHexString() + "'>Stretching</b>)");
					}
					if(Sex.getAreasTooLoosePartner().contains(OrificeType.VAGINA_PARTNER)) {
						modifiersList.add("-0.5 <b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>arousal</b> (<b style='color: " + Colour.GENERIC_BAD.toWebHexString() + "'>Too loose</b>)");
					}
					if(Sex.getWetOrificeTypes().get(OrificeType.VAGINA_PARTNER).isEmpty()) {
						modifiersList.add("-1 <b style='color: " + Colour.GENERIC_SEX.toWebHexString() + "'>arousal</b> (<b style='color: " + Colour.GENERIC_BAD.toWebHexString() + "'>Dry</b>)");
						
					}
				}
			}
			
			return modifiersList;
		}

		@Override
		public String getDescription(GameCharacter target) {
			descriptionSB = new StringBuilder();
			
			if(target.isPlayer()) {
				descriptionSB.append("<p style='text-align:center;margin-top:0;'>");
				
				if(Sex.getPenetrationTypeInOrifice(OrificeType.VAGINA_PLAYER) != null) {
					switch(Sex.getPenetrationTypeInOrifice(OrificeType.VAGINA_PLAYER)){
						case FINGER_PLAYER:
							descriptionSB.append("You are <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>fingering</b> yourself!");
							break;
						case FINGER_PARTNER:
							descriptionSB.append("[npc.Name] is <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>fingering</b> you!");
							break;
							
						case PENIS_PLAYER:
							descriptionSB.append("You are <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>fucking</b> yourself!");
							break;
						case PENIS_PARTNER:
							descriptionSB.append("[npc.Name] is <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>fucking</b> you!");
							break;
							
						case TAIL_PARTNER:
							descriptionSB.append("[npc.Name] is <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>tail-fucking</b> you!");
							break;
						case TAIL_PLAYER:
							descriptionSB.append("You are <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>tail-fucking</b> yourself!");
							break;
							
						case TONGUE_PARTNER:
							descriptionSB.append("[npc.Name] is <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>eating you out</b>!");
							break;
						case TONGUE_PLAYER:
							descriptionSB.append("You are performing <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>autocunnilingus</b>!");
							break;
						default:
							descriptionSB.append("<b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>Penetrated.</b>");
							break;
					}
				} else {
					descriptionSB.append("<b style='color:"+Colour.TEXT_GREY.toWebHexString()+";'>No penetration.</b>");
				}
				
				if(Sex.getAreasCurrentlyStretchingPlayer().contains(OrificeType.VAGINA_PLAYER)) {
					descriptionSB.append("</br>Your "+Main.game.getPlayer().getVaginaName(true)+" is being <b style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>stretched</b>!");
					
				} else if(Sex.getAreasTooLoosePlayer().contains(OrificeType.VAGINA_PLAYER)) {
					descriptionSB.append("</br>Your "+Main.game.getPlayer().getVaginaName(true)+" is <b style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>too loose</b>!");
				} else {
					descriptionSB.append("</br><b style='color:"+Colour.TEXT_GREY.toWebHexString()+";'>No stretch effect.</b>");
				}
				
				
				if(Sex.getWetOrificeTypes().get(OrificeType.VAGINA_PLAYER).isEmpty()) {
					descriptionSB.append("</br>Your "+Main.game.getPlayer().getVaginaName(true)+" is <b style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>dry</b>!");
					
				} else {
					descriptionSB.append("</br>Your "+Main.game.getPlayer().getVaginaName(true)+" has been <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>lubricated</b> by:</br>");
					int i=0;
					for(LubricationType lt : Sex.getWetOrificeTypes().get(OrificeType.VAGINA_PLAYER)) {
						if(i!=0) {
							if(i == Sex.getWetOrificeTypes().get(OrificeType.VAGINA_PLAYER).size()-1) {
								descriptionSB.append(", and ");
							} else {
								descriptionSB.append(", ");
							}
						}
						
						if(i==0)
							descriptionSB.append(Util.capitaliseSentence(lt.getName()));
						else
							descriptionSB.append(lt.getName());
						
						if(i == Sex.getWetOrificeTypes().get(OrificeType.VAGINA_PLAYER).size()-1) {
							descriptionSB.append(".");
						}
						
						i++;
					}
				}
				descriptionSB.append("</p>");
				
			} else {
				descriptionSB.append("<p style='text-align:center;margin-top:0;'>");
				
				if(Sex.getPenetrationTypeInOrifice(OrificeType.VAGINA_PARTNER) != null) {
					switch(Sex.getPenetrationTypeInOrifice(OrificeType.VAGINA_PARTNER)){
						case FINGER_PLAYER:
							descriptionSB.append("You are <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>fingering</b> [npc.name]!");
							break;
						case FINGER_PARTNER:
							descriptionSB.append(UtilText.genderParsing(Sex.getPartner(),
									"[npc.Name] is <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>fingering</b> <herPro>self!"));
							break;
							
						case PENIS_PARTNER:
							descriptionSB.append(UtilText.genderParsing(Sex.getPartner(),
									"[npc.Name] is <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>fucking</b> <herPro>self!"));
							break;
						case PENIS_PLAYER:
							descriptionSB.append("You are <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>fucking</b> [npc.name]!");
							break;
							
						case TAIL_PLAYER:
							descriptionSB.append("You are <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>tail-fucking</b> [npc.name]!");
							break;
						case TAIL_PARTNER:
							descriptionSB.append(UtilText.genderParsing(Sex.getPartner(),
									"[npc.Name] is <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>tail-fucking <herPro>self</b>!"));
							break;
							
						case TONGUE_PARTNER:
							descriptionSB.append("[npc.Name] is performing <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>autocunnilingus</b>!");
							break;
						case TONGUE_PLAYER:
							descriptionSB.append("You are <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>eating out</b> [npc.name]!");
							break;
						default:
							descriptionSB.append("<b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>Penetrated.</b>");
							break;
					}
				} else {
					descriptionSB.append("<b style='color:"+Colour.TEXT_GREY.toWebHexString()+";'>No penetration.</b>");
				}
				
				if(Sex.getAreasCurrentlyStretchingPartner().contains(OrificeType.VAGINA_PARTNER)) {
					descriptionSB.append("</br>[npc.Name]'s "+Sex.getPartner().getVaginaName(true)+" is being <b style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>stretched</b>!");
					
				} else if(Sex.getAreasTooLoosePartner().contains(OrificeType.VAGINA_PARTNER)) {
					descriptionSB.append("</br>[npc.Name]'s "+Sex.getPartner().getVaginaName(true)+" is <b style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>too loose</b>!");
				} else {
					descriptionSB.append("</br><b style='color:"+Colour.TEXT_GREY.toWebHexString()+";'>No stretch effect.</b>");
				}
				
				
				if(Sex.getWetOrificeTypes().get(OrificeType.VAGINA_PARTNER).isEmpty()) {
					descriptionSB.append("</br>[npc.Name]'s "+Sex.getPartner().getVaginaName(true)+" is <b style='color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>dry</b>!");
					
				} else {
					descriptionSB.append("</br>[npc.Name]'s "+Sex.getPartner().getVaginaName(true)+" has been <b style='color:"+Colour.GENERIC_SEX.toWebHexString()+";'>lubricated</b> by:</br>");
					int i=0;
					for(LubricationType lt : Sex.getWetOrificeTypes().get(OrificeType.VAGINA_PARTNER)) {
						if(i!=0) {
							if(i == Sex.getWetOrificeTypes().get(OrificeType.VAGINA_PARTNER).size()-1) {
								descriptionSB.append(", and ");
							} else {
								descriptionSB.append(", ");
							}
						}
						
						if(i==0)
							descriptionSB.append(Util.capitaliseSentence(lt.getName()));
						else
							descriptionSB.append(lt.getName());
						
						if(i == Sex.getWetOrificeTypes().get(OrificeType.VAGINA_PARTNER).size()-1) {
							descriptionSB.append(".");
						}
						
						i++;
					}
				}
				descriptionSB.append("</p>");
			}
			
			
			return descriptionSB.toString();
		}

		@Override
		public boolean isConditionsMet(GameCharacter target) {
			if(Main.game.isInSex()) {
				return target.hasVagina();
				
			} else {
				return false;
			}
		}
		
		@Override
		public boolean isSexEffect() {
			return true;
		}
		
		@Override
		public String getSVGString(GameCharacter owner) {
			SVGImageSB = new StringBuilder();
			
			SVGImageSB.append(SVGImages.SVG_IMAGE_PROVIDER.getCoverableAreaVagina());
			
			if(owner.isPlayer()) {
				if(Sex.getPenetrationTypeInOrifice(OrificeType.VAGINA_PLAYER) != null) {
					switch(Sex.getPenetrationTypeInOrifice(OrificeType.VAGINA_PLAYER)){
						case FINGER_PLAYER: case FINGER_PARTNER:
							SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getPenetrationTypeFinger()+"</div>");
							break;
						case PENIS_PLAYER: case PENIS_PARTNER:
							SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getPenetrationTypePenis()+"</div>");
							break;
						case TAIL_PLAYER: case TAIL_PARTNER:
							SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getPenetrationTypeTail()+"</div>");
							break;
						case TONGUE_PLAYER: case TONGUE_PARTNER:
							SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getPenetrationTypeTongue()+"</div>");
							break;
						default:
							break;
					}
				}
				
				if(Sex.getAreasCurrentlyStretchingPlayer().contains(OrificeType.VAGINA_PLAYER)) {
					SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getCombinationStretching()+"</div>");
				}
				
				if(Sex.getAreasTooLoosePlayer().contains(OrificeType.VAGINA_PLAYER)) {
					SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getCombinationTooLoose()+"</div>");
				}
				
				if(Sex.getWetOrificeTypes().get(OrificeType.VAGINA_PLAYER).isEmpty()) {
					SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getCombinationDry()+"</div>");
				} else {
					SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getCombinationWet()+"</div>");
				}
				
			} else {
				if(Sex.getPenetrationTypeInOrifice(OrificeType.VAGINA_PARTNER) != null) {
					switch(Sex.getPenetrationTypeInOrifice(OrificeType.VAGINA_PARTNER)){
						case FINGER_PLAYER: case FINGER_PARTNER:
							SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getPenetrationTypeFinger()+"</div>");
							break;
						case PENIS_PLAYER: case PENIS_PARTNER:
							SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getPenetrationTypePenis()+"</div>");
							break;
						case TAIL_PLAYER: case TAIL_PARTNER:
							SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getPenetrationTypeTail()+"</div>");
							break;
						case TONGUE_PLAYER: case TONGUE_PARTNER:
							SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getPenetrationTypeTongue()+"</div>");
							break;
						default:
							break;
					}
				}

				if(Sex.getAreasCurrentlyStretchingPartner().contains(OrificeType.VAGINA_PARTNER)) {
					SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getCombinationStretching()+"</div>");
				}
				
				if(Sex.getAreasTooLoosePartner().contains(OrificeType.VAGINA_PARTNER)) {
					SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getCombinationTooLoose()+"</div>");
				}
				
				if(Sex.getWetOrificeTypes().get(OrificeType.VAGINA_PARTNER).isEmpty()) {
					SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getCombinationDry()+"</div>");
				} else {
					SVGImageSB.append("<div style='width:100%;height:100%;position:absolute;left:0;bottom:0;'>"+SVGImages.SVG_IMAGE_PROVIDER.getCombinationWet()+"</div>");
				}
			}
			
			return SVGImageSB.toString();
		}
	};

	private int renderingPriority;
	private String name;
	private Colour colourShade;
	private boolean beneficial;
	private Map<Attribute, Float> attributeModifiers;

	private String SVGString;

	private List<String> extraEffects;

	protected List<String> modifiersList;
	
	private static StringBuilder descriptionSB, SVGImageSB;

	private StatusEffect(int renderingPriority, String name, String pathName, Colour colourShade, boolean beneficial, Map<Attribute, Float> attributeModifiers, List<String> extraEffects) {
		this.renderingPriority = renderingPriority;
		this.name = name;
		this.beneficial = beneficial;
		this.attributeModifiers = attributeModifiers;
		this.colourShade = colourShade;

		this.extraEffects = extraEffects;

		if(pathName!=null) {
			try {
				InputStream is = this.getClass().getResourceAsStream("/com/base/res/statusEffects/" + pathName + ".svg");
				SVGString = Util.inputStreamToString(is);
	
				SVGString = SVGString.replaceAll("#ff2a2a", colourShade.getShades()[0]);
				SVGString = SVGString.replaceAll("#ff5555", colourShade.getShades()[1]);
				SVGString = SVGString.replaceAll("#ff8080", colourShade.getShades()[2]);
				SVGString = SVGString.replaceAll("#ffaaaa", colourShade.getShades()[3]);
				SVGString = SVGString.replaceAll("#ffd5d5", colourShade.getShades()[4]);
	
				is.close();
	
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			SVGString = "";
		}

		modifiersList = new ArrayList<>();

		if (attributeModifiers != null) {
			for (Entry<Attribute, Float> e : attributeModifiers.entrySet())
				modifiersList.add("<b>" + (e.getValue() > 0 ? "+" : "") + e.getValue() + "</b>" + " <b style='color: " + e.getKey().getColour().toWebHexString() + ";'>" + Util.capitaliseSentence(e.getKey().getAbbreviatedName()) + "</b>");
		}

		if (extraEffects != null)
			for (String s : extraEffects)
				modifiersList.add(s);
	}

	public abstract String applyEffect(GameCharacter target, int minutesPassed);

	/**
	 * @param target
	 * @return True if this status effect should be applied to the target. False
	 *         if conditions are not met <b>or</b> this status effect is only
	 *         for timed purposes (i.e. the only time it should be applied is
	 *         with a time condition.).
	 */
	public abstract boolean isConditionsMet(GameCharacter target);
	
	public boolean renderInEffectsPanel() {
		return true;
	}
	
	public boolean isCombatEffect() {
		return false;
	}
	
	public boolean isSexEffect() {
		return false;
	}
	
	public float getArousalPerTurnSelf(GameCharacter target) {
		return 0;
	}
	
	public float getArousalPerTurnPartner(GameCharacter target) {
		return 0;
	}

	public final String applyRemoveStatusEffect(GameCharacter target) {
		reverseStatusEffectAttributeModifiers(target);
		return extraRemovalEffects(target);
	}
	
	protected String extraRemovalEffects(GameCharacter target){
		return "";
	}
	
	private void reverseStatusEffectAttributeModifiers(GameCharacter target) {
		if (getAttributeModifiers(target) != null)
			for (Entry<Attribute, Float> e : getAttributeModifiers(target).entrySet())
				target.incrementBonusAttribute(e.getKey(), -e.getValue());
	}

	public int getRenderingPriority() {
		return renderingPriority;
	}

	public String getName(GameCharacter target) {
		return name;
	}

	public abstract String getDescription(GameCharacter target);

	public List<String> getModifiersAsStringList(GameCharacter target) {
		return modifiersList;
	}

	public boolean isBeneficial() {
		return beneficial;
	}

	public Map<Attribute, Float> getAttributeModifiers(GameCharacter target) {
		return attributeModifiers;
	}

	public Colour getColour() {
		return colourShade;
	}

	public List<String> getExtraEffects() {
		return extraEffects;
	}

	public String getSVGString(GameCharacter owner) {
		return SVGString;
	}
}
