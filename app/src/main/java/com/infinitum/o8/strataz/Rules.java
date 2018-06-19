package com.infinitum.o8.strataz;

public class Rules {
    private String ruleName;
    private String ruleInfo;

    public static final Rules[] rule = {
            new Rules("Rules Table of Contents", "+ Game Overview\n\n" +
                    "+ Game Objective\n\n" +
                    "+ Game Set-Up\n" +
                    "\t - Game Pieces\n" +
                    "\t - Turn Order\n\n" +
                    "+ During Your Turn\n" +
                    "\t - Primary: Upkeep\n" +
                    "\t - Secondary: Constructing & Creating\n" +
                    "\t - Tertiary: Move/Actions\n" +
                    "\t - Exploration\n" +
                    "\t - Sabotage\n" +
                    "\t - Survey the Land\n" +
                    "\t - Instant\n\n" +
                    "+ Numbers\n\n" +
                    "+ Resources\n\n" +
                    "+ Tiles\n" +
                    "\t - Resource Tiles\n\n" +
                    "+ Units\n\n" +
                    "+ Tile Improvements\n\n" +
                    "+ Intersection Structures\n\n" +
                    "+ Exploration Roll\n" +
                    "\t - Arcane Tower\n" +
                    "\t - Ruin\n" +
                    "\t - Fort\n" +
                    "\t - Factory\n\n" +
                    "+ Homes\n" +
                    "\t - Home Complexity\n\n" +
                    "+ Combat\n\n" +
                    "+ Societal Progression (SP Cards)\n\n" +
                    "+ Win Conditions\n\n"),
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
                    "\t - Instant Actions can be done at any moment in time. Societal Progression cards can be played at any moment (unless otherwise specified)\n"),
            new Rules("Numbers", "\t+ If you encounter a number that cannot be operated on without resulting in a whole number, round up at the tenth decimal point and use that number instead"),
            new Rules("Rolls", "+ D20 Roll:\n" +
                    "\t - Roll a D20, use that result unless otherwise specified\n" +
                    "+ D6 Roll:\n" +
                    "\t - Roll a D6, divide that number in half, rounding up and write that number on the Modifier Slot (Ex: 5/2= 2.5, Result = 3)\n"),
            new Rules("Resource List", "+ Lumber:\n" +
                    "\t - Cedar\n" +
                    "\t - Maple\n" +
                    "+ Metal:\n" +
                    "\t - Copper\n" +
                    "\t - Iron\n" +
                    "+ Food:\n" +
                    "\t - Grain\n" +
                    "\t - Livestock\n" +
                    "+ Strategic:\n" +
                    "\t - Horse\n" +
                    "\t - Gravel\n" +
                    "\t - Orb of Intellect\n"),
            new Rules("Tiles", "+ Adjacency:\n" +
                    "\t - 4 Way Adjacency: Resource Tiles are connected by both octogonal edges and square intersections. The 4-Way adjacency of a Resource Tile, is the diagonal corners of the octagon that connect directly with another octagon. Resource Tiles connected by an intersection are considered an extra Movement Point worth of space away, compared to a directly connecting Tile.\n" +
                    "\t\t -- Intersection spaces cannot be landed on\n" +
                    "\t - Intersection Adjacency: The 4 Resource Tiles connected to the Intersection Square\n" +
                    "+ Claiming a Tile:\n" +
                    "\t - To claim a Tile, you must use a Worker to Work that land, build a Building on that land, or Purchase the Tile\n" +
                    "\t - The Tile must be adjacent to an owned Tile\n" +
                    "\t - Once a Tile is under your ownership, color in the Flag Slot with your color\n" +
                    "+ Purchasing a Tile:\n" +
                    "\t - Cost: Gold 200\n" +
                    "\t - Must be 4-Way Adjacent to an owned Tile\n" +
                    "+ Mountain Tiles:\n" +
                    "\t - Mountain Tiles have 4 Movement Cost. You may attempt an OoI Roll with a Scholar when on a Mountain Tile. If successful, you receive 1 OoI, instead of the potential 2 from the OoI Mountain\n"),
            new Rules("Units", "Civilian Units\n" +
                    "+ Civilian Units are unable to attack, but can be attacked by Opponent Units\n" +
                    "\t - Civilian Units do an Escape Roll (Roll a D20) instead when attacked, with the Opponent making an Attack Roll (Roll a D20). Subtract the Attack Roll from the Escape Roll\n" +
                    "\t - If the Civilian Unit loses, the attacking Player gains control of that Civilian Unit\n" +
                    "+ Settlers:\n" +
                    "\t - Cost: Food 100, Lumber 100, Metal 100\n" +
                    "\t - Settlers must establish Homes at least 2 Tiles away from any other Home, including the Player’s and any other Opponent’s Homes\n" +
                    "\t - When a Home is established, gain 25 of each resource 4-Way adjacent to the Home\n" +
                    "+ Workers:\n" +
                    "\t - Cost: Food 50, Lumber 50\n" +
                    "\t - When a builder works a Resource Tile, you receive the full amount of Resources at the beginning of your upkeep\n" +
                    "+ Merchants:\n" +
                    "\t - Cost: Food 50, Lumber: 50, Metal: 25\n" +
                    "\t - Merchants have 5 Movement Points\n" +
                    "\t - When a merchant reaches another Home then the one it was created at, you receive 50 Gold\n" +
                    "\t - If that Home is an Opponent’s Home and they accept it, you gain 100 Gold and your Opponent receives 25 Gold\n" +
                    "+ Scholars:\n" +
                    "\t - Cost: Food 50, Lumber 50, Metal 50\n" +
                    "\t - When a Scholar moves onto an Intersection Tile containing an Arcane Tower, you may make an Enlightenment Roll\n" +
                    "\t\t\t --- Roll a D20\n" +
                    "\t\t\t --- 0-5 Nothing Happens, move your Scholar back to its previous Unit Space\n" +
                    "\t\t\t --- 6-10 Gain 1 OoI\n" +
                    "\t\t\t --- 11-15 Gain 2 OoI\n" +
                    "\t\t\t --- 16-20 Gain 3 OoI, destroy the Arcane Tower\n" +
                    "Military Units\n\n" +
                    "+ General Terms:\n" +
                    "\t - Lvl: Level\n" +
                    "\t\t -- The Level of the Unit; increased levels boost Unit Stats\n" +
                    "\t\t -- See Experience & Leveling for more information\n" +
                    "\t - HP: Health Points\n" +
                    "\t\t -- The amount of Health your Unit has, once this reaches 0, the Unit dies\n" +
                    "\t - Atk: Attack Strength\n" +
                    "\t\t -- The Base Strength of an Attack made by this Unit\n" +
                    "\t\t -- Weapon Upgrade:\n" +
                    "\t\t\t --- Iron: \n" +
                    "\t\t\t --- Cost: Lumber 50, Iron 100, Gold 50 \n" +
                    "\t\t\t --- Info: Atk +5\n" +
                    "\t\t -- Atk Modifier:\n" +
                    "\t\t\t --- Make a D6 Roll\n" +
                    "\t - Def: Defensive Power\n" +
                    "\t\t -- The Base resilience of this Unit’s Defense, protecting it from damage before it’s HP\n" +
                    "\t\t -- Armor Upgrade:\n" +
                    "\t\t\t --- Head:\n" +
                    "\t\t\t\t ---- Cost: Lumber 25, Iron 25, Gold 25\n" +
                    "\t\t\t\t ---- Def +5\n" +
                    "\t\t\t --- Chest: \n" +
                    "\t\t\t\t ---- Cost: Lumber 25, Iron 75, Gold 50\n" +
                    "\t\t\t\t ---- Def +5\n" +
                    "\t\t\t --- Legs: \n" +
                    "\t\t\t\t ---- Cost: Lumber 25, Iron 50, Gold 25\n" +
                    "\t\t\t\t ---- Def +5\n" +
                    "\t - MP: Movement Points\n" +
                    "\t\t -- The amount of Movement available to this Unit, per turn\n" +
                    "Army Units:\n" +
                    "+ Warriors: \n" +
                    "\t - Cost: Food 50, Lumber 50, Metal 100, Gold 25\n" +
                    "\t - Stats: HP 20, Attack 20 , Defense 20, MP: 3\n" +
                    "\t - Warriors can Attack other Units and Homes\n" +
                    "\t - Warriors can Conquer a Home\n" +
                    "\t - Warriors can Sabotage\n" +
                    "+ Archers:\n" +
                    "\t - Cost: Food 50, Lumber 100, Metal 50, Gold 25\n" +
                    "\t - Stats: HP 30, Attack 10, Defense 10, MP: 4\n" +
                    "\t - Archers can Attack other Units and Homes. Since they Attack from a distance, it eliminates the Opponent’s ability to Counter-Attack.\n" +
                    "\t - Archers can Sabotage\n" +
                    "+ Horseman:\n" +
                    "\t - Cost: Food 100, Lumber 50, Metal 100, Gold 25\n" +
                    "\t - Stats: HP 20, Attack 30, Defense 10, MP: 6\n" +
                    "\t - Horseman can Attack other Units and Homes\n" +
                    "\t - Horsemen can Conquer a Home\n" +
                    "\t - Horsemen can Sabotage\n" +
                    "+ Rams:\n" +
                    "\t - Cost: Food 50, Lumber 100, Metal 100\n" +
                    "\t - Stats: HP 30, Attack 50, Defense 20, MP: 2\n" +
                    "\t - Rams can only Attack Homes\n" +
                    "\t - Rams receive a bonus of +25 Damage when making a Damage Roll against a Home’s Walls only, not the Home’s HP\n" +
                    "\t - See Combat for Ram and Home Siege Attacking information\n" +
                    "+ Spies:\n" +
                    "\t - Cost: Food 25, Lumber 50, Metal 50, Gold 25, OoI 2\n" +
                    "\t - Spies can perform Sabotage\n" +
                    "\t - Spies can Steal an Opponent’s SP card, chosen at random. When this happens, destroy the Spy\n" +
                    "\t - Spies do not Move, and thus have no MP\n"),
            new Rules("Resource Tile Improvement", "+ Roads:\n" +
                    "\t - Cost: Lumber 25, Gravel 50, Gold 10\n" +
                    "\t - When purchased, color in the Road Slot on the Tile with your Societies’ color\n" +
                    "\t - Tile Movement cost is reduced by half (Movement cost cannot be lower than 1)\n" +
                    "\t - Color in the Road Slot with your color\n" +
                    "+ Stable:\n" +
                    "\t - Must be built on a Horses Resource Tile\n" +
                    "\t - Cost: Food 100, Lumber 50, Metal 50\n" +
                    "\t - Movement cost for all of your units reduced by 1 (Movement cost cannot be lower than 1)\n" +
                    "\t - If a Player does not own a Stable, but possesses 250 Horses, they receive this bonus\n" +
                    "\t - Write Sa in the Building Slot\n" +
                    "+ Mine:\n" +
                    "\t - Cost: Food 25, Lumber 100, Metal 50\n" +
                    "\t - Must be built on a Metal Resource Tile\n" +
                    "\t - Doubles the Resource Amount on this Resource Tile\n" +
                    "\t - Write Mi in the Building Slot\n" +
                    "+ Lumber Mill:\n" +
                    "\t - Cost: Food 25, Lumber 50, Metal 50\n" +
                    "\t - Must be built on a Lumber Resource Tile\n" +
                    "\t - Double the Resource Amount on this Resource Tile\n" +
                    "\t - Write Lu in the Building Slot\n" +
                    "+ Farm:\n" +
                    "\t - Cost: Food 25, Lumber 50, Metal 25\n" +
                    "\t - Must be built on a Food Resource Tile\n" +
                    "\t - Double the Resource Amount on this Resource Tile\n" +
                    "\t - Write Fa in the Building Slot\n"),
            new Rules("Intersection Structures", "+ Intersections cannot be explored on the same turn that they are discovered\n" +
                    "+ To explore an intersection, you must have a unit occupying the same tile and make a Exploration Roll\n" +
                    "+ Exploration Roll: Roll a D20\n" +
                    "\t - 0-10 The intersection is empty\n" +
                    "\t - 11-15 Arcane Tower\n" +
                    "\t - 16-20 Ruin\n" +
                    "+ Arcane Tower: Towers Powered by OoI\n" +
                    "\t\t -- Study at Arcane Tower with a Scholar: D20 Roll\n" +
                    "\t\t -- 0-10 Nothing happens\n" +
                    "\t\t -- 11-15 Gain 1 OoI, discard Scholar\n" +
                    "\t\t -- 16-20 Gain 2 OoI, discard Scholar\n" +
                    "+ Ruin: Ruins Full of Ancient Tech\n" +
                    "\t - Search Ruins: D20 Roll\n" +
                    "\t\t -- 0-1 Nothing happens\n" +
                    "\t\t -- 2-4 Gain 25 Gold\n" +
                    "\t\t -- 5-10 Gain a Worker\n" +
                    "\t\t -- 11-15 Gain a Merchant\n" +
                    "\t\t -- 16-20 Gain a Scholar\n" +
                    "\t - The ruins collapse after you make a successful roll\n" +
                    "+ Fort: Defensive Building - Player Built\n" +
                    "\t - Cost: Food 100, Lumber 100, Metal 100, Gravel 50\n" +
                    "\t - HP: 50, Attack 20\n" +
                    "+ Factory: Processes Resources - Player Built\n" +
                    "\t - Cost: Food 50, Lumber 150, Metal 50, Gold 50\n" +
                    "\t - Gain Double the Resources from Adjacent Tiles\n"),
            new Rules("Homes", "+ Home Cards stay face-down until you create a correlating Home\n" +
                    "+ When a Home’s HP reaches 0 HP, it loses its ability to receive Resources until it is repaired\n" +
                    "\t - Repair: The cost of Repairing a Home is equal to the cost of the Complexity of the Home (Settlement = Food 100, Lumber 100, Metal 100; Town = Grain 200, Cedar 150, Copper 150)\n" +
                    "+ Modifiers:\n" +
                    "\t - Modifiers require a Modification Slot; Max 2 per Home\n" +
                    "\t - Gold or Food:\n" +
                    "\t\t -- Cost: Food 100, Lumber 50, Metal 50, Gold 100\n" +
                    "\t\t -- Double either your Gold/Turn or Food/Turn\n" +
                    "\t\t -- Write Go for Gold, or Fo for Food\n" +
                    "+ HP or Defense:\n" +
                    "\t\t -- Cost: Food 50, Lumber 100, Metal 100, Gold 100\n" +
                    "\t\t -- Double either your Health Points or Defense\n" +
                    "\t\t -- Write HP for Health Points, or De for Defense\n" +
                    "+ Invincibility:\n" +
                    "\t\t -- Cost: Food 100, Lumber 100, Metal 100, Gold 100\n" +
                    "\t\t -- Activate this Mod when you are being Attacked by an Opponent; prevent all damage for this turn and discard this Mod\n" +
                    "\t\t -- Write In for Invincibility\n" +
                    "+ ProtoTower:\n" +
                    "\t\t -- Cost: Food 50, Lumber 50, Metal 50, Gold 200\n" +
                    "\t\t -- Whenever you gain an OoI, receive 1 extra\n" +
                    "\t\t -- Write Pr for ProtoTower\n\n" +
                    "+ Buildings:\n" +
                    "+ Grainery: \n" +
                    "\t\t -- Cost: Food 50, Lumber 50, Metal 50\n" +
                    "\t\t -- Make a D20 Roll, add the result to your Home’s Food/Turn\n" +
                    "\t\t -- Graineries require a Building slot\n" +
                    "\t\t -- Write Bu in the Building Slot\n" +
                    "+ Barracks:\n" +
                    "\t\t -- Cost: Food 100, Lumber 50, Metal 100, Gold 25\n" +
                    "\t\t -- Gain 1 Military Unit of your choice of either a Warrior, Archer, or Horseman\n" +
                    "\t\t -- Military Units built in this Home cost half of their base cost\n" +
                    "\t\t -- Write Ba in the Building Slot\n" +
                    "+ Walls:\n" +
                    "\t\t -- Cost: Lumber 100, Metal 100, Gravel 100, Gold 25\n" +
                    "\t\t -- This Home now has 50 Defense, attacking Players must bring this Home’s Defense to 0 before dealing damage to the Home’s HP\n" +
                    "\t\t -- Write Wa in the Building Slot\n" +
                    "+ University: \n" +
                    "\t\t -- Cost: Food 100, Lumber 100, Metal 50, OoI 1, Gold 50\n" +
                    "\t\t -- SP cards cost half their base cost\n" +
                    "\t\t -- Scholars cost half their base cost\n" +
                    "\t\t -- Write Un in the Building Slot\n" +
                    "+ Marketplace:\n" +
                    "\t\t -- Cost: Food 50, Lumber 50, Gold 100\n" +
                    "\t\t -- Double Gold/Turn from this Home\n" +
                    "\t\t -- Write Ma in the Building Slot\n\n" +
                    "+ Unit Slots:\n" +
                    "\t\t -- Only 1 Unit can occupy a Unit Slot\n" +
                    "\t\t -- The Total number of Unit Slots in your Society is equal to the Total number of Military Units you can possess (10 Max)\n"),
            new Rules("Home Complexity", "+ Settlement:\n" +
                    "\t - Cost (Settler Cost): Food 100, Lumber 100, Metal 100\n" +
                    "\t - Stats: HP 25, Food 5/turn, Gold: 1/turn\n" +
                    "\t - Buildings: 1, Units: 1, Modifiers: 0\n" +
                    "+ Village:\n" +
                    "\t - Cost: Food 150, Cedar 100, Copper 100\n" +
                    "\t - Stats: HP 50, Food 10/turn, Gold: 5/turn\n" +
                    "\t - Buildings: 1, Units: 1, Modifiers: 1\n" +
                    "+ Town\n" +
                    "\t - Cost: Grain 200, Cedar 150, Copper 150\n" +
                    "\t - Stats: HP 75, Food 15/turn, Gold 10/turn\n" +
                    "\t - Buildings: 2, Units: 1, Modifiers: 1\n" +
                    "+ City\n" +
                    "\t - Cost: Livestock 250, Maple 200, Iron 200, Gravel 100, OoI 2\n" +
                    "\t - Stats: HP 100, Food 20/turn, Gold 15/turn\n" +
                    "\t - Buildings: 3, Units: 2, Modifiers: 1\n" +
                    "+ Metropolis\n" +
                    "\t - Cost: Livestock 250, Maple 250, Iron 250, Gravel 150, OoI 5\n" +
                    "\t - Stats: HP 125, Food 25/turn, Gold 20/turn\n" +
                    "\t - Buildings: 4, Units: 2, Modifiers: 2\n"),
            new Rules("Combat", "Experience & Leveling" +
                    "+ Unit’s begin at Level 0" +
                    "+ When you defeat another Unit, place an Experience Token on to the Lvl Slot on the Unit’s card\n" +
                    "+ When there are 2 Experience Tokens, put both Tokens back to your Bank, and increase that Unit’s Level by 1 (add bonus to base stat)\n" +
                    "\t - Level 1: Atk +2, Def +2\n" +
                    "\t - Level 2: Atk +4, Def +4\n" +
                    "\t - Level 3: HP +5, Atk +6, Def +6\n" +
                    "\t - Level 4: HP +10, Atk +8, Def +8, MP +1\n" +
                    "\t - Level 5: HP +10, Atk +10, Def +10, MP +2\n" +
                    "Melee: (Instance of A attacking B)\n" +
                    "\t - A makes an Attack Roll (Roll a D20) and then B makes an Escape Roll (Roll a D20)\n" +
                    "\t\t -- If A wins, A makes a Damage Roll\n" +
                    "\t\t\t --- D20 Roll + A Unit’s Attack = A’s Damage; A’s Damage - B’s HP\n" +
                    "\t\t -- If B wins, B escapes the battle\n" +
                    "\t - If B survives the attack, they can make a Counter-Attack Roll (Damage Roll - 10 damage)\n" +
                    "Ranged: (A attacking B, in an adjacent tile) \n" +
                    "\t - Same as Melee, except no option of a counter-attack since it is from a distance\n" +
                    "Home Siege: (A attacking Home, Home has a military unit, B)\n" +
                    "\t - Same as Melee, except the defending player can choose to defend with his Home or B. If defending with the Home, the Home does not deal damage.The defending player can choose B to defend instead, and without the counter-attack penalty\n" +
                    "\t - If a Home’s HP reaches 0, the Home is Conquered, the attacking player can choose to either destroy the Home or Conquer, taking it over for themselves\n" +
                    "\t\t -- If the Home is taken by the attacking player, the defending player must give them all of their associated cards for that Home\n" +
                    "Ram: (A attacking Home)\n" +
                    "\t - The same as a Home Siege, except it can only attack a Home, dealing direct damage to the Home’s walls, and then HP\n" +
                    "\t - Ram’s cannot Conquer a Home, if the Home reaches 0 HP, it loses its ability to gain Resources\n" +
                    "\t - Ram’s cannot attack other military units\n"),
            new Rules("Win Conditions", "+ Militaristic:\n" +
                    "\t - Defeat all Opponents by taking all of their Homes with no Opponent Settlers left on board\n" +
                    "\t - Standing Army (5 Warriors, 5 Archers, 2 Rams, 2 Spies)\n" +
                    "\t - 5 Metropolises\n" +
                    "\t - 15 SP Cards\n" +
                    "+ Economic:\n" +
                    "\t - 1000 Gold\n" +
                    "\t - 10 Currently worked Resources\n" +
                    "\t - 5 Metropolises\n" +
                    "\t - 2 Merchants\n" +
                    "\t - 15 SP Cards\n" +
                    "+ Imperialistic:\n" +
                    "\t - All Tiles discovered\n" +
                    "\t - Own more than 50% of the board (At full size, >32 tiles)\n" +
                    "\t - 5 Cities\n" +
                    "+ Intellectual:\n" +
                    "\t - 20 Orbs of Intellect\n" +
                    "\t - 5 Metropolises\n" +
                    "\t - 5 Universities\n" +
                    "\t - 2 Scholars\n" +
                    "\t - 15 SP Cards\n" +
                    "+ Social:\n" +
                    "\t - 10 Orbs of Intellect\n" +
                    "\t - 5 Metropolises\n" +
                    "\t - 30 SP Cards\n"),
            new Rules("Glossary", "")
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