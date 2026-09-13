package mars_project;

import jadescript.content.onto.Ontology_Vocabulary;

@SuppressWarnings("all")
public interface MarsOntology_Vocabulary extends Ontology_Vocabulary {
  public static final String DoNextSlot = "DoNextSlot";

  public static final String DoMoveTowards = "DoMoveTowards";

  public static final String DoMoveTowards_targetX = "targetX";

  public static final String DoMoveTowards_targetY = "targetY";

  public static final String DoPick = "DoPick";

  public static final String DoDrop = "DoDrop";

  public static final String DoBurn = "DoBurn";

  public static final String Percepts = "Percepts";

  public static final String Percepts_myX = "myX";

  public static final String Percepts_myY = "myY";

  public static final String Percepts_r2X = "r2X";

  public static final String Percepts_r2Y = "r2Y";

  public static final String Percepts_hasGarbage = "hasGarbage";

  public static final String PickedSuccessfully = "PickedSuccessfully";

  public static final String PickFailed = "PickFailed";

  public static final String GarbageAtBase = "GarbageAtBase";

  public static final String ActionCompleted = "ActionCompleted";
}
