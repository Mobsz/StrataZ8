package com.infinitum.o8.strataz;

public class Rules {
    private String ruleName;
    private String ruleInfo;

    public static final Rules[] rule = {
            new Rules("Rules Table of Contents", "Game Overview\n\n" +
                    "Game Objective\n\n" +
                    "Game Set-Up\n" +
                    "\tGame Pieces\n" +
                    "\tTurn Order\n\n" +
                    "During Your Turn\n" +
                    "\tPrimary: Upkeep\n" +
                    "\tSecondary: Constructing & Creating\n" +
                    "\tTertiary: Move/Actions\n" +
                    "\tExploration\n" +
                    "\tSabotage\n" +
                    "\tSurvey the Land\n" +
                    "\tInstant\n\n" +
                    "Numbers\n\n" +
                    "Resources\n\n" +
                    "Tiles\n" +
                    "\tResource Tiles\n\n" +
                    "Units\n\n" +
                    "Tile Improvements\n\n" +
                    "Intersection Structures\n\n" +
                    "Exploration Roll\n" +
                    "\tArcane Tower\n" +
                    "\tRuin\n" +
                    "\tFort\n" +
                    "\tFactory\n\n" +
                    "Homes\n" +
                    "\tHome Complexity\n\n" +
                    "Combat\n\n" +
                    "Phases\n" +
                    "Exploration\n\n" +
                    "Sabotage\n\n" +
                    "Survey the Land\n\n" +
                    "Instant\n\n" +
                    "Societal Progression (SP Cards)\n\n" +
                    "Win Conditions\n\n"),
            new Rules("Game Overview", "One species, divided by an unending race for supremacy. Opting to fall into the narcissistic abyss of unregulated hubris, instead of selflessly rising in unity as one. In spite of the relentless tribulations spawned by the world and Universe they inhabit, they choose to waste energy on trivial problems, unaware of the greater powers that be within the Universe. They were no more than sprouts, perpetually hindering their growth up the hierarchy of the Universal tree of life. Wielding the knowledge gained through ancient technology, this species was able to reach previously unattainable goals. Inherently, there is a need to explore and thusly so the species spread, dividing along different paths as they went. As the people of this world expanded and explored, they found peculiar structures spread throughout the lands. Dilapidated ruins of a long lost civilization so technologically advanced, it seemed as though it were magic. Blueprints for world altering machines have been found, along with modular mechanical parts. A massive mountain, at which the main societies gather around for its ancient power. Perhaps, someday there will be a leader, capable of progressing society by means of cooperation, or conquest. This, is only the beginning."),
            new Rules("Game Objective", "You are the leader of your people. It is your job to steer the progress of history, which will be made by your actions. Will you be a kind and benevolent leader, opting for trade and worldwide success as one species? Or will you become a maniacal Warmonger, mind set on expanding your empire, taking over every land you come across? You will encounter many tough decisions and experience policies and actions that although either good or evil, will still progress you as a whole, learning from your mistakes and reveling in your successes. Good luck mighty Leader, may you have many successes in all your adventures and endeavors."),
            new Rules("Game Set-up", "Game Pieces:\n" +
                    "+ Dice:\n" +
                    "\t - 1 D20\n" +
                    "\t - 1 D6\n\n" +
                    "+ Resource Tiles: (64)\n" +
                    "\t - 1 Main Mountain\n" +
                    "\t - 9 Cedar\n" +
                    "\t - 9 Maple\n" +
                    "\t - 9 Copper\n" +
                    "\t - 9 Iron\n" +
                    "\t - 9 Grain\n" +
                    "\t - 9 Livestock\n" +
                    "\t - 3 Horses\n" +
                    "\t - 3 Gravel\n" +
                    "\t - 3 Mountains\n\n" +
                    "+ Player Held Tiles: (10-40)\n" +
                    "\t - 5-20 Home\n" +
                    "\t - 5-20 Warrior, Archer, Horsemen, Ram\n\n" +
                    "+ Unit Pieces: (60) 40Civ, 20Mil\n" +
                    "\t - 1-4 Settlers\n" +
                    "\t - 10-40 Workers\n" +
                    "\t - 2-8 Scholars\n" +
                    "\t - 2-8 Merchants\n" +
                    "\t - 2-8 Warriors\n" +
                    "\t - 2-8 Archers\n" +
                    "\t - 2-8 Horsemen\n" +
                    "\t - 2-8 Rams\n\n" +
                    "+ SP Cards: (60)\n\n" +
                    "+ Resource Cards (4 Total):\n" +
                    "\t - Cedar\n" +
                    "\t - Maple\n" +
                    "\t - Copper\n" +
                    "\t - Iron\n" +
                    "\t - Grain\n" +
                    "\t - Livestock\n" +
                    "\t - Horses\n" +
                    "\t - Gravel\n" +
                    "\t - OoI\n\n" +
                    "+ Society Symbol:\n" +
                    "\t - Choose a Symbol to represent your Society. This is what you will write when you establish a Home.\n\n" +
                    "+ Turn Order:\n" +
                    "\t - Highest roll of a D20 goes first\n" +
                    "\t\t -- If there is a tie, all of the tied Players roll again until there are no identical numbers\n" +
                    "\t\t -- After the highest number is determined, that Player goes first, followed by the Player clockwise to them.\n\n" +
                    "\t - Shuffle Tile and SP Stacks\n\n" +
                    "\t - Place Main Mountain in the middle of the table\n" +
                    "\t\t -- Next, draw a Resource Tile from the stack and place it on the lower left corner (Picture). Roll for the Resource Amount (D20), and the Intersection Structure (D20)\n" +
                    "\t\t -- Continue to draw 16 more Resource Tiles, placing them clockwise around the Main Mountain (Picture)\n" +
                    "\t\t -- Each player gains Grain 50, Cedar 50, Copper 50\n" +
                    "\t\t -- The first Player places a Home in any of the Resource Tiles, when that happens, that player gains 50 of that resource\n" +
                    "\t\t -- The rest of the Players do the same thing clockwise\n"),
            new Rules("During Your Turn", "+ At any moment during your turn, you are allowed to trade with any of the other Players\n" +
                    "\t - Trading:\n" +
                    "\t\t -- Players are allowed to trade with other players whatever they want, for whatever they want\n" +
                    "\t\t -- Players may Convert resources into any other by Converting 5:1. If the Resource is of the same Resource Type (Ex: Cedar for Maple, Copper for Iron, or Grain for Livestock), you may trade it by paying 2:1.\n" +
                    "\t\t\t --- A Resource must have been discovered to Convert\n\n" +
                    "\t - Purchasing Tiles:\n" +
                    "\t\t -- Tiles are purchasable for 150 Gold. The Tile must be adjacent to one of your Homes and unoccupied by another Player’s Home\n\n" +
                    "+ Primary: Upkeep\n" +
                    "\t - At the beginning of your Upkeep Phase, receive resources from the 4 adjacent tiles to each of your Homes, equal to the half of the number indicated by the resource amount on that tile.\n" +
                    "\t\t -- If you have a Worker working on that tile, you receive the full amount indicated on the Resource Tile’s Resource Amount\n" +
                    "\t\t -- Remember to check if there are any modifiers or workers working the land that would affect the tile’s resource amount\n" +
                    "\t - A player can only store 255 of each Resource Type (Food, Lumber, or Metal) & only 20 OoI per Player (50 max in game), this means that you cannot have 255 cords of Cedar and 255 cords of Maple, but you can have 123 cords of one and 122 of the other.\n" +
                    "\t - You can only receive resources on your upkeep turn (unless otherwise specified).\n\n" +
                    "+ Secondary: Constructing & Creating\n" +
                    "\t - Constructing:\n" +
                    "\t\t -- You are now allowed to construct anything that you have the proper resources for, but only while in this phase. Buildings may have different resource costs of amount and type of resource. \n" +
                    "\t\t\t --- Ex: A Settler to build a Home costs Food(Grain or Livestock): 100, Lumber(Cedar or Maple): 100, Metal(Copper or Iron): 100, meaning that any type of Food, Lumber, or Metal resource will work. On the other hand, a Village costs Food(Grain or Livestock): 150, Cedar: 100, Copper: 100, which means that you specifically need Cedar and Copper, and either Grain or Livestock.\n" +
                    "\t\t -- Buildings may only be Constructed on a player owned Home or 4-Way adjacent tile to one of their Homes.\n" +
                    "\t\t -- When a Building is Constructed on a Tile, that Tile becomes a part of that Player’s Society (Place Player’s Flag on Tile)\n" +
                    "\t\t -- You may create a Home with a Settler, if that Settler has not moved this turn\n\n" +
                    "\t - Creating:\n" +
                    "\t\t -- You are also allowed to Create any Unit that you have the proper resources for. The resource costs follows the same rules as Constructing.\n" +
                    "\t\t -- You can only sustain as many Units as you have Unit Spaces in your whole Society\n" +
                    "\t\t -- Created Units spawn in the Unit Spaces of any of that player’s Homes that they choose. If all of the Unit Spaces are occupied, the player may place the Unit in any Tile that is adjacent to one of their Homes.\n" +
                    "\t\t -- A Unit cannot move on the same turn it is Created (unless otherwise specified). \n" +
                    "+ Tertiary: Move/Actions\n" +
                    "\t - Unit Movement:\n" +
                    "\t\t -- Units are not allowed to move or attack on the same turn they are Created. They are allowed to defend against an attack, following the rules of engagement.\n" +
                    "\t\t -- A Unit can move after attacking, as long as it has enough Movement Points\n" +
                    "\t\t -- A Unit can travel the amount that is specified by their Movement Points\n" +
                    "\t\t\t --- Tiles may cost different amounts, which is indicated on the tile in the Movement Cost slot.\n" +
                    "\t\t\t\t ---- Sea Level: 1, Hill: 2, Mountain: 4\n" +
                    "\t\t\t --- (Movement Points - Movement Cost) Subtract the Tile’s Movement Cost from the Unit’s Movement Points when it travels to the tile. A Unit is only allowed to move to a tile that it has enough points for.\n" +
                    "\t\t\t\t ---- Ex: Warrior Unit has 1 Movement Point left this turn and is attempting to reach a hill tile, which costs 2 Movement Points to travel to. The Warrior Unit is unable to travel to the tile, because it does not have enough Movement Points.\n" +
                    "\t\t\t --- When a Unit travels onto another Tile, it occupies a Unit Space slot on that Tile. If there is not an empty Unit Space slot, the Unit cannot move on to that Tile. Each Tile contains 2 Worker slots and 2 Unit Space slots. The Worker slots can only sustain Workers and the Unit Space slots can sustain any type of Unit, including workers. This means that on a Resource Tile, you can have 2 Workers and 2 Units, 3 Workers and 1 Unit, or 4 Workers.\n\n" +
                    "+ Exploration:\n" +
                    "\t - During the Tertiary Phase, you can move off of your current Tile toward an Unexplored edge, you will then take the top Tile from the Tile Stack and place it face up, attached to the rest of the Game Board where you are Exploring.\n" +
                    "\t - Now that you have explored a new Tile, you need to make an Exploration Roll (Roll a D20), instructions can be found at Intersection Structures\n" +
                    "\t\t -- Intersection Structures cannot be interacted with on the same turn that they are Explored\n" +
                    "+ Sabotage:\n" +
                    "\t - Military Units may Sabotage another Player’s Building on a Resource Tile by performing a Sabotage Roll\n" +
                    "\t\t -- Sabotage Roll: Roll a D20\n" +
                    "\t\t\t --- 0-10 Nothing happens\n" +
                    "\t\t\t --- 11-16 Unit is captured by opposing Player, opposing Player rolls a D20:\n" +
                    "\t\t\t\t ---- 0-10 They would not join your side, they must go\n" +
                    "\t\t\t\t ---- 11-20 They join your society\n" +
                    "\t\t\t --- 16-20\n" +
                    "\t\t\t\t ---- The building is destroyed and the Sabotaging Player receives 50 Gold\n\n" +
                    "+ Survey the Land:\n" +
                    "\t - Once per turn, you may Survey the Land to reroll for the Resources Amount on an owned Resource Tile (You may only do this for 1 Tile per turn)\n" +
                    "\t - Cost: Resource Tile Type 50\n" +
                    "\t\t -- Survey Roll: Roll a D20\n" +
                    "\t\t -- Resource Amount on that Tile is now equal to the rolled result\n\n" +
                    "+ Instant:\n" +
                    "\t - Instant Actions can be done at any moment in time. Societal Progression cards can be played at any moment (unless otherwise specified)\n")

    };

    public Rules (String ruleName, String ruleInfo){
        this.ruleInfo = ruleInfo;
        this.ruleName = ruleName;
    }

    public String getRuleName(){
        return ruleName;
    }

    public String getRuleInfo(){
        return ruleInfo;
    }
}