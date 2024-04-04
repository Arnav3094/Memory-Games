package com.arnav.memorygames;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.Random;

public class WordsFragment_Display extends Fragment {
	private static final String TAG = "WordsFragment_Display";
	public CountDownTimer countDownTimer;
	public int remainingTime;
	ProgressBar progressBar;
	TextView timerText;
	//List<String> list =new ArrayList<String>();
	//list = ["consider", "minute", "accord", "evident", "practice", "intend"];
	TextView word1;
	TextView word2;
	TextView word3;
	TextView word4;
	TextView word5;
	TextView word6;
	TextView word7;
	TextView word8;
	String[] totalWords = new String[89];
	String[] words = new String[8];

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_words_display, container, false);
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		progressBar = requireView().findViewById(R.id.progressBar);
		word1 = requireView().findViewById(R.id.word1);
		word2 = requireView().findViewById(R.id.word2);
		word3 = requireView().findViewById(R.id.word3);
		word4 = requireView().findViewById(R.id.word4);
		word5 = requireView().findViewById(R.id.word5);
		word6 = requireView().findViewById(R.id.word6);
		word7 = requireView().findViewById(R.id.word7);
		word8 = requireView().findViewById(R.id.word8);

/*        totalWords = new String[]{
                "consider", "minute", "accord", "evident", "practice", "intend", "conduct", "engage", "obtain", "scarce", "policy", "straight",
                "stock", "apparent", "property", "fancy", "concept", "court", "appoint", "passage", "vain", "instance", "coast", "project",
                "commission", "constant", "circumstances", "constitute", "level", "affect", "institute", "render", "appeal", "generate",
                "theory", "range", "campaign", "league", "labor", "confer", "grant", "dwell", "entertain", "contract", "earnest","yield",
                "wander", "insist", "knight", "convince", "inspire", "convention", "skill", "harry", "financial", "reflect", "novel", "furnish",
                "compel", "venture", "territory", "temper", "bent", "intimate", "undertake", "majority", "crew", "chamber", "humble", "scheme",
                "keen", "liberal", "despair", "tide", "attitude", "justify", "flag", "merit", "manifest", "notion", "scale", "formal",
                "resource", "persist", "contempt","bat","ball","cricket","watch"
        }; //89
*/
		totalWords = new String[]{
				"aback", "abaft", "abashed", "aberrant", "abiding", "abject", "ablaze", "able", "abnormal", "aboard", "abortive", "abrasive", "abrupt", "absent", "absorbed", "absurd", "abundant", "abusive", "accurate", "acid", "acidic", "acoustic", "acrid", "actually", "ad hoc", "adamant", "addicted", "adhesive", "adorable", "afraid", "ahead", "ajar", "alert", "alike", "alive", "alleged", "alluring", "aloof", "amazing", "amuck", "amused", "amusing", "ancient", "angry", "animated",
				"annoyed", "annoying", "anxious", "aquatic", "aromatic", "arrogant", "ashamed", "aspiring", "assorted", "average", "awake", "aware", "awesome", "awful", "bad", "bashful", "bawdy", "bent", "berserk", "best", "better", "big", "billowy", "bitter", "bizarre", "black", "bloody", "blue", "blushing", "boiling", "boorish", "bored", "boring", "bouncy", "brainy", "brash", "brave", "brawny", "breezy", "brief", "bright", "bright", "broad", "broken", "brown", "bumpy", "burly",
				"bustling", "busy", "cagey", "callous", "calm", "capable", "careful", "careless", "caring", "cautious", "certain", "charming", "cheap", "cheerful", "chemical", "chief", "chilly", "chubby", "chunky", "clammy", "classy", "clean", "clear", "clever", "cloudy", "closed", "clumsy", "coherent", "cold", "colorful", "colossal", "common", "complete", "complex", "confused", "cooing", "cool", "cowardly", "crabby", "craven", "crazy", "creepy", "crooked", "crowded", "cruel", "cuddly",
				"cultured", "curious", "curly", "curved", "curvy", "cut", "cute", "cute", "cynical", "daffy", "daily", "damaged", "damaging", "damp", "dapper", "dark", "dashing", "dazzling", "dead", "deadpan", "dear", "debonair", "decisive", "decorous", "deep", "deeply", "defeated", "defiant", "delicate", "demonic", "deranged", "deserted", "detailed", "devilish", "didactic", "diligent", "direful", "dirty", "discreet", "distinct", "dizzy", "doubtful", "drab", "dramatic", "dreary", "drunk",
				"dry", "dull", "dusty", "dusty", "dynamic", "eager", "early", "earthy", "easy", "eatable", "economic", "educated", "eight", "elastic", "elated", "elderly", "electric", "elegant", "elfin", "elite", "eminent", "empty", "enormous", "envious", "equable", "equal", "erect", "erratic", "ethereal", "evasive", "even", "excited", "exciting", "exotic", "exultant", "fabulous", "faded", "faint", "fair", "faithful", "false", "familiar", "famous", "fancy",
				"far", "fast", "fat", "faulty", "fearful", "fearless", "feeble", "feigned", "female", "fertile", "festive", "few", "fierce", "filthy", "fine", "finicky", "first", "five", "fixed", "flagrant", "flaky", "flashy", "flat", "flawless", "flimsy", "flippant", "flowery", "fluffy", "foamy", "foolish", "four", "frail", "fragile", "frantic", "free", "freezing", "frequent", "fresh", "fretful", "friendly", "full", "fumbling", "funny", "furry", "furtive", "future", "fuzzy", "gabby",
				"gainful", "gamy", "gaping", "gaudy", "general", "gentle", "giant", "giddy", "gifted", "gigantic", "gleaming", "glib", "glorious", "glossy", "godly", "good", "goofy", "gorgeous", "graceful", "grateful", "gratis", "gray", "greasy", "great", "greedy", "green", "grey", "grieving", "groovy", "grouchy", "grubby", "gruesome", "grumpy", "guarded", "gullible", "gusty", "guttural", "habitual", "half", "hallowed", "halting", "handsome", "handy", "hanging", "hapless", "happy",
				"hard", "harsh", "hateful", "heady", "healthy", "heavenly", "heavy", "hellish", "helpful", "helpless", "hesitant", "hideous", "high", "hissing", "holistic", "hollow", "homeless", "homely", "horrible", "hot", "huge", "hulking", "humdrum", "humorous", "hungry", "hurried", "hurt", "hushed", "husky", "hypnotic", "icky", "icy", "idiotic", "ignorant", "ill", "illegal", "immense", "imminent", "impolite", "imported", "infamous", "innate", "innocent", "internal", "irate", "itchy",
				"jaded", "jagged", "jazzy", "jealous", "jittery", "jobless", "jolly", "joyous", "juicy", "jumbled", "jumpy", "juvenile", "kaput", "keen", "kind", "kindly", "knotty", "knowing", "known", "labored", "lacking", "lame", "languid", "large", "last", "late", "lavish", "lazy", "lean", "learned", "left", "legal", "lethal", "level", "lewd", "light", "like", "likeable", "limping", "literate", "little", "lively", "lively", "living", "lonely", "long", "longing", "loose", "lopsided",
				"loud", "loutish", "lovely", "loving", "low", "lowly", "lucky", "lumpy", "lush", "lying", "lyrical", "macabre", "macho", "madly", "magenta", "magical", "majestic", "male", "mammoth", "maniacal", "many", "marked", "massive", "married", "material", "mature", "mean", "measly", "meaty", "medical", "meek", "mellow", "melodic", "melted", "merciful", "mere", "messy", "mighty", "military", "milky", "mindless", "minor", "misty", "mixed", "moaning",
				"modern", "moldy", "muddled", "mundane", "murky", "mushy", "mute", "naive", "nappy", "narrow", "nasty", "natural", "naughty", "near", "neat", "nebulous", "needless", "needy", "nervous", "new", "next", "nice", "nifty", "nimble", "nine", "nippy", "noisy", "nonstop", "normal", "nosy", "noxious", "null", "numerous", "nutty", "oafish", "obedient", "obeisant", "obese", "obscene", "obsolete", "oceanic", "odd", "offbeat", "old", "one", "onerous", "open", "opposite", "optimal",
				"orange", "ordinary", "organic", "ossified", "outgoing", "oval", "overt", "painful", "pale", "paltry", "panicky", "parallel", "parched", "past", "pastoral", "pathetic", "peaceful", "penitent", "perfect", "periodic", "petite", "petite", "phobic", "physical", "picayune", "pink", "piquant", "placid", "plain", "plant", "plastic", "pleasant", "plucky", "poised", "polite", "poor", "possible", "powerful", "precious", "premium", "present", "pretty", "previous", "pricey",
				"prickly", "private", "probable", "profuse", "proud", "public", "puffy", "pumped", "puny", "purple", "purring", "pushy", "puzzled", "puzzling", "quack", "quaint", "quick", "quickest", "quiet", "quirky", "quixotic", "rabid", "racial", "ragged", "rainy", "rampant", "rapid", "rare", "raspy", "ratty", "ready", "real", "rebel", "red", "regular", "relieved", "resolute", "resonant", "rich", "right", "rightful", "rigid", "ripe", "ritzy", "roasted", "robust", "romantic", "roomy",
				"rotten", "rough", "round", "royal", "ruddy", "rude", "rural", "rustic", "ruthless", "sable", "sad", "safe", "salty", "same", "sassy", "savory", "scarce", "scared", "scary", "scrawny", "second", "secret", "sedate", "seemly", "selfish", "separate", "serious", "shaggy", "shaky", "shallow", "sharp", "shiny", "shocking", "short", "shrill", "shut", "shy", "sick", "silent", "silent", "silky", "silly", "simple", "sincere", "six", "skillful", "skinny", "sleepy", "slim", "slimy",
				"slippery", "sloppy", "slow", "small", "smart", "smelly", "smiling", "smoggy", "smooth", "sneaky", "snobbish", "snotty", "soft", "soggy", "solid", "somber", "sordid", "sore", "sore", "sour", "special", "spicy", "spiffy", "spiky", "spiteful", "splendid", "spooky", "spotless", "spotted", "spotty", "spurious", "squalid", "square", "staking", "stale", "standing", "steady", "steep", "sticky", "stiff", "stingy", "stormy", "straight", "strange",
				"strong", "stupid", "sturdy", "subdued", "succinct", "sudden", "sulky", "super", "superb", "supreme", "swanky", "sweet", "swift", "taboo", "tacit", "tacky", "talented", "tall", "tame", "tan", "tangible", "tangy", "tart", "tasteful", "tasty", "tawdry", "tearful", "tedious", "teeny", "telling", "ten", "tender", "tense", "tense", "tenuous", "terrible", "terrific", "tested", "testy", "thankful", "thick", "thin", "third", "thirsty", "thirsty", "three", "tidy", "tight", "tiny",
				"tired", "tiresome", "torpid", "tough", "towering", "tranquil", "trashy", "tricky", "trite", "troubled", "true", "truthful", "two", "typical", "ugliest", "ugly", "ultra", "unable", "unarmed", "unbiased", "unequal", "uneven", "unique", "unkempt", "unknown", "unruly", "untidy", "unused", "unusual", "unwieldy", "upbeat", "uppity", "upset", "uptight", "used", "useful", "useless", "utopian", "utter", "vacuous", "vagabond", "vague", "valuable", "various", "vast", "vengeful",
				"venomous", "verdant", "versed", "vigorous", "violent", "violet", "volatile", "vulgar", "wacky", "waggish", "waiting", "wakeful", "wanting", "warlike", "warm", "wary", "wasteful", "watery", "weak", "wealthy", "weary", "well-off", "wet", "white", "whole", "wicked", "wide", "wiggly", "wild", "willing", "windy", "wiry", "wise", "wistful", "witty", "womanly", "wooden", "woozy", "workable", "worried", "wrathful", "wretched", "wrong", "wry", "yellow", "yielding", "young", "youthful",
				"yummy", "zany", "zealous", "zesty", "zippy", "zonked", "account", "achiever", "act", "action", "activity", "actor", "addition", "advice", "air", "airplane", "airport", "alarm", "amount", "anger", "angle", "animal", "ants", "apparel", "approval", "arch", "argument", "arm", "army", "art", "attack", "aunt", "babies", "baby", "back", "badge", "bag", "bait", "balance", "ball", "base", "baseball", "basin", "basket", "bat", "bath", "battle", "bead", "bear", "bed", "bedroom", "beds",
				"bee", "beef", "beginner", "behavior", "belief", "believe", "bell", "bells", "berry", "bike", "bikes", "bird", "birds", "birth", "birthday", "bit", "bite", "blade", "blood", "blow", "board", "boat", "bomb", "bone", "book", "books", "boot", "border", "bottle", "boundary", "box", "boy", "brake", "branch", "brass", "breath", "brick", "bridge", "brother", "bubble", "bucket", "building", "bulb", "burst", "bushes", "business",
				"button", "cabbage", "cable", "cactus", "cake", "cakes", "calendar", "camera", "camp", "can", "cannon", "canvas", "cap", "caption", "car", "card", "care", "carriage", "cars", "cart", "cast", "cat", "cats", "cattle", "cause", "cave", "celery", "cellar", "cemetery", "cent", "chalk", "chance", "change", "channel", "cheese", "cherries", "cherry", "chess", "chicken", "chickens", "children", "chin", "church", "circle", "clam", "class", "cloth", "clover", "club", "coach", "coal",
				"coast", "coat", "cobweb", "coil", "collar", "color", "company", "control", "cook", "copper", "corn", "cough", "country", "cover", "cow", "cows", "crack", "cracker", "crate", "crayon", "cream", "creator", "creature", "credit", "crib", "crime", "crook", "crow", "crowd", "crown", "cub", "cup", "current", "curtain", "curve", "cushion", "dad", "daughter", "day", "death", "debt", "decision", "deer", "degree", "design", "desire", "desk", "detail", "dime", "dinner", "dirt",
				"distance", "division", "dock", "doctor", "dog", "dogs", "doll", "dolls", "donkey", "door", "downtown", "drain", "drawer", "dress", "drink", "driving", "drop", "duck", "ducks", "dust", "ear", "earth", "edge", "effect", "egg", "eggnog", "eggs", "elbow", "end", "engine", "error", "event", "example", "exchange", "expert", "eye", "eyes", "face", "fact", "fairies", "fall", "fang", "farm", "fear", "feeling", "field", "finger", "finger", "fire", "fireman", "fish", "flag", "flame",
				"flavor", "flesh", "flight", "flock", "floor", "flower", "flowers", "fly", "fog", "fold", "food", "foot", "force", "fork", "form", "fowl", "frame", "friction", "friend", "friends", "frog", "frogs", "front", "fruit", "fuel", "gate", "geese", "ghost", "giants", "giraffe", "girl", "girls", "glass", "glove", "gold", "governor", "grade", "grain", "grape", "grass", "grip", "ground", "group", "growth", "guide", "guitar", "gun", "hair", "haircut", "hall", "hammer", "hand", "hands",
				"harbor", "harmony", "hat", "hate", "head", "health", "heat", "hill", "history", "hobbies", "hole", "holiday", "home", "honey", "hook", "hope", "horn", "horse", "horses", "hose", "hospital", "hot", "hour", "house", "houses", "humor", "hydrant", "ice", "icicle", "idea", "impulse", "income", "increase", "industry", "ink", "insect", "interest", "iron", "island", "jail", "jam", "jar", "jeans", "jelly", "jewel", "join", "judge",
				"kettle", "key", "kick", "kiss", "kittens", "kitty", "knee", "knife", "knot", "laborer", "lace", "ladybug", "lake", "lamp", "land", "language", "laugh", "leather", "leg", "legs", "letter", "letters", "lettuce", "level", "library", "limit", "line", "linen", "lip", "liquid", "loaf", "lock", "locket", "look", "loss", "love", "low", "lumber", "lunch", "machine", "magic", "maid", "mailbox", "man", "marble", "mark", "market", "mask", "mass", "match", "meal", "measure", "meat",
				"meeting", "memory", "men", "metal", "mice", "middle", "milk", "mind", "mine", "minister", "mint", "minute", "mist", "mitten", "mom", "money", "monkey", "month", "moon", "morning", "mother", "motion", "mountain", "mouth", "move", "muscle", "name", "nation", "neck", "need", "needle", "nerve", "nest", "night", "noise", "north", "nose", "note", "notebook", "number", "nut", "oatmeal", "ocean", "offer", "office", "oil", "orange", "oranges", "order", "oven", "page", "pail",
				"pan", "pancake", "paper", "parcel", "part", "partner", "party", "payment", "peace", "pear", "pen", "pencil", "person", "pest", "pet", "pets", "pickle", "picture", "pie", "pies", "pig", "pigs", "pin", "pipe", "pizzas", "place", "plane", "planes", "plant", "plants", "plastic", "plate", "play", "pleasure", "plot", "plough", "pocket", "point", "poison", "popcorn", "porter", "position", "pot", "potato", "powder", "power", "price", "produce", "profit", "property", "prose", "protest",
				"pull", "pump", "purpose", "push", "quarter", "quartz", "queen", "question", "quiet", "quill", "quilt", "quince", "quiver", "rabbit", "rabbits", "rail", "railway", "rain", "rake", "range", "rat", "rate", "ray", "reaction", "reading", "reason", "receipt", "recess", "record", "regret", "relation", "religion", "request", "respect", "rest", "reward", "rhythm", "rice", "riddle", "rifle", "ring", "rings", "river", "road", "robin", "rock", "rod", "roll", "roof", "room", "root", "rose",
				"route", "rub", "rule", "run", "sack", "sail", "salt", "sand", "scale", "scarf", "scene", "scent", "school", "science", "scissors", "screw", "sea", "seashore", "seat", "seed", "self", "sense", "servant", "shade", "shake", "shame", "shape", "sheep", "sheet", "shelf", "ship", "shirt", "shock", "shoe", "shoes", "shop", "show", "side", "sidewalk", "sign", "silk", "silver", "sink", "sister", "sisters", "size", "skate",
				"sky", "slave", "sleep", "sleet", "slip", "slope", "smash", "smell", "smile", "smoke", "snail", "snails", "snake", "snakes", "sneeze", "snow", "soap", "society", "sock", "soda", "sofa", "son", "song", "songs", "sort", "sound", "soup", "space", "spade", "spark", "spiders", "sponge", "spoon", "spot", "spring", "spy", "square", "squirrel", "stage", "stamp", "star", "start", "station", "steam", "steel", "stem", "step", "stew", "stick", "sticks", "stitch", "stocking",
				"stomach", "stone", "stop", "store", "story", "stove", "stranger", "straw", "stream", "street", "stretch", "string", "sugar", "suit", "summer", "sun", "support", "surprise", "sweater", "swim", "swing", "system", "table", "tail", "talk", "tank", "taste", "tax", "teaching", "team", "teeth", "temper", "tendency", "tent", "test", "texture", "theory", "thing", "things", "thought", "thread", "thrill", "throat", "throne", "thumb", "thunder", "ticket", "tiger", "time", "tin",
				"title", "toad", "toe", "toes", "tomatoes", "tongue", "tooth", "top", "touch", "town", "toy", "toys", "trade", "trail", "train", "trains", "tramp", "tray", "tree", "trees", "trick", "trip", "trouble", "trousers", "truck", "trucks", "tub", "turkey", "turn", "twig", "twist", "umbrella", "uncle", "unit", "use", "vacation", "value", "van", "vase", "veil", "vein", "verse", "vessel", "vest", "view", "visitor", "voice", "volcano", "voyage", "walk", "wall", "war", "wash", "waste",
				"watch", "water", "wave", "waves", "wax", "way", "wealth", "weather", "week", "weight", "wheel", "whip", "whistle", "wind", "window", "wine", "wing", "winter", "wire", "wish", "woman", "women", "wood", "wool", "word", "work", "worm", "wound", "wren", "wrench", "wrist", "writer", "writing", "yak", "yam", "yard", "yarn", "year", "yoke", "zebra", "zephyr", "zinc", "zipper", "zoo", "accept", "add", "admire", "admit", "advise", "afford", "agree", "alert", "allow", "amuse", "analyse",
				"announce", "annoy", "answer", "appear", "applaud", "approve", "argue", "arrange", "arrest", "arrive", "ask", "attach", "attack", "attempt", "attend", "attract", "avoid", "back", "bake", "balance", "ban", "bang", "bare", "bat", "bathe", "battle", "beam", "beg", "behave", "belong", "bleach", "bless", "blind", "blink", "blot", "blush", "boast", "boil", "bolt", "bomb", "book", "bore", "borrow", "bounce", "bow", "box", "brake",
				"bruise", "brush", "bubble", "bump", "burn", "bury", "buzz", "call", "camp", "care", "carry", "carve", "cause", "change", "charge", "chase", "cheat", "check", "cheer", "chew", "choke", "chop", "claim", "clap", "clean", "clear", "clip", "close", "coach", "coil", "collect", "colour", "comb", "command", "compare", "compete", "complain", "complete", "concern", "confess", "confuse", "connect", "consider", "consist", "contain", "continue", "copy", "correct", "cough", "count",
				"cover", "crack", "crash", "crawl", "cross", "crush", "cry", "cure", "curl", "curve", "cycle", "dam", "damage", "dance", "dare", "decay", "deceive", "decide", "decorate", "delay", "delight", "deliver", "depend", "describe", "desert", "deserve", "destroy", "detect", "develop", "disagree", "disarm", "discover", "dislike", "divide", "double", "doubt", "drag", "drain", "dream", "dress", "drip", "drop", "drown", "drum", "dry", "dust", "earn", "educate", "employ", "empty",
				"end", "enjoy", "enter", "escape", "examine", "excite", "excuse", "exercise", "exist", "expand", "expect", "explain", "explode", "extend", "face", "fade", "fail", "fancy", "fasten", "fax", "fear", "fence", "fetch", "file", "fill", "film", "fire", "fit", "fix", "flap", "flash", "float", "flood", "flow", "flower", "fold", "follow", "fool", "force", "form", "found", "frame", "frighten", "fry", "gather", "gaze", "glow", "glue", "grab", "grate", "grease", "greet", "grin", "grip",
				"groan", "guard", "guess", "guide", "hammer", "hand", "handle", "hang", "happen", "harass", "harm", "hate", "haunt", "head", "heal", "heap", "heat", "help", "hook", "hop", "hope", "hover", "hug", "hum", "hunt", "hurry", "identify", "ignore", "imagine", "impress", "improve", "include", "increase", "inform", "inject", "injure", "instruct", "intend", "interest", "invent", "invite", "irritate", "itch", "jail", "jam", "jog", "join", "joke", "judge", "juggle", "jump", "kick", "kill",
				"kiss", "kneel", "knit", "knock", "knot", "label", "land", "last", "laugh", "launch", "learn", "level", "license", "lick", "lie", "lighten", "like", "list", "listen", "live", "load", "lock", "long", "look", "love", "man", "manage", "march", "mark", "marry", "match", "mate", "matter", "measure", "meddle", "melt", "memorise", "mend", "mess up", "milk", "mine", "miss", "mix", "moan", "moor", "mourn", "move", "muddle",
				"nail", "name", "need", "nest", "nod", "note", "notice", "number", "obey", "object", "observe", "obtain", "occur", "offend", "offer", "open", "order", "overflow", "owe", "own", "pack", "paddle", "paint", "park", "part", "pass", "paste", "pat", "pause", "peck", "pedal", "peel", "peep", "perform", "permit", "phone", "pick", "pinch", "pine", "place", "plan", "plant", "play", "please", "plug", "point", "poke", "polish", "pop", "possess", "post", "pour", "practise", "pray",
				"preach", "precede", "prefer", "prepare", "present", "preserve", "press", "pretend", "prevent", "prick", "print", "produce", "program", "promise", "protect", "provide", "pull", "pump", "punch", "puncture", "punish", "push", "question", "queue", "race", "radiate", "rain", "raise", "reach", "realise", "receive", "record", "reduce", "reflect", "refuse", "regret", "reign", "reject", "rejoice", "relax", "release", "rely", "remain", "remember", "remind", "remove", "repair",
				"repeat", "replace", "reply", "report", "request", "rescue", "retire", "return", "rhyme", "rinse", "risk", "rob", "rock", "roll", "rot", "rub", "ruin", "rule", "rush", "sack", "sail", "satisfy", "save", "saw", "scare", "scatter", "scold", "scorch", "scrape", "scratch", "scream", "screw", "scribble", "scrub", "seal", "search", "separate", "serve", "settle", "shade", "share", "shave", "shelter", "shiver", "shock", "shop", "shrug", "sigh", "sign", "signal", "sin", "sip", "ski",
				"skip", "slap", "slip", "slow", "smash", "smell", "smile", "smoke", "snatch", "sneeze", "sniff", "snore", "snow", "soak", "soothe", "sound", "spare", "spark", "sparkle", "spell", "spill", "spoil", "spot", "spray", "sprout", "squash", "squeak", "squeal", "squeeze", "stain", "stamp", "stare", "start", "stay", "steer", "step", "stir", "stitch", "stop", "store", "strap", "stretch", "strip", "stroke", "stuff", "subtract", "succeed", "suck", "suffer", "suggest", "suit", "supply",
				"support", "suppose", "surprise", "surround", "suspect", "suspend", "switch", "talk", "tame", "tap", "taste", "tease", "tempt", "terrify", "test", "thank", "thaw", "tick", "tickle", "tie", "time", "tip", "tire", "touch", "tour", "tow", "trace", "trade", "train", "trap", "travel", "treat", "tremble", "trick", "trip", "trot", "trouble", "trust", "try", "tug", "tumble", "turn", "twist", "type", "undress", "unfasten",
				"striped", "butter", "juice", "jump", "skin", "skirt", "branch", "breathe", "mug", "multiply", "murder", "unite", "unlock", "unpack", "untidy", "use", "vanish", "visit", "wail", "wait", "walk", "wander", "want", "warm", "warn", "wash", "waste", "watch", "water", "wave", "weigh", "welcome", "whine", "whip", "whirl", "whisper", "whistle", "wink", "wipe", "wish", "wobble", "wonder", "work", "worry", "wrap", "wreck", "wrestle", "wriggle", "x-ray", "yawn", "yell", "zip", "zoom"
		};

		timerText = requireView().findViewById(R.id.timerText);

		Random rand = new Random();
		for (int i = 0; i < 8; i++) {
			words[i] = totalWords[rand.nextInt(80)];
		}
		word1.setText(words[0]);
		word2.setText(words[1]);
		word3.setText(words[2]);
		word4.setText(words[3]);
		word5.setText(words[4]);
		word6.setText(words[5]);
		word7.setText(words[6]);
		word8.setText(words[7]);

		countDownTimer = new CountDownTimer(5000, 10) {
			@Override
			public void onTick(long millisUntilFinished) {
				remainingTime = (int) millisUntilFinished / 1000;
				int progress = (int) millisUntilFinished / 50;
				timerText.setText(String.valueOf(remainingTime + 1));
				progressBar.setProgress(progress, true);
			}

			@Override
			public void onFinish() {
				String str = "Time Up";
				timerText.setText(str);
				FragmentManager manager = requireActivity().getSupportFragmentManager();
				FragmentTransaction transaction = manager.beginTransaction();
				WordsFragment_Selection WordsFragmentSelect = new WordsFragment_Selection();

				Log.d(TAG, "onFinish: Sending Number");
				Bundle bundle = new Bundle();
				bundle.putCharSequenceArray("CorrectWords", words);
				WordsFragmentSelect.setArguments(bundle);

				transaction.replace(R.id.frameLayout, WordsFragmentSelect);
				transaction.commit();
			}
		};
		countDownTimer.start();

		super.onViewCreated(view, savedInstanceState);
	}
}
