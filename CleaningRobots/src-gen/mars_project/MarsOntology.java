package mars_project;

import jadescript.content.onto.Ontology;
import jadescript.core.exception.ExceptionThrower;
import jadescript.core.exception.JadescriptException;

@SuppressWarnings("all")
public class MarsOntology extends Ontology implements MarsOntology_Vocabulary {
  private ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__DEFAULT_THROWER;

  public void __handleJadescriptException(final JadescriptException __exc) {
    jadescript.core.exception.ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__getExceptionEscalator(MarsOntology.this);
    boolean __handled = false;
    if(!__handled) {
    	__thrower.__throwJadescriptException(__exc);
    }
  }

  private void __initializeProperties() {
    // Initializing properties and event handlers:
    {
    }
  }

  private static Ontology _superOntology = null;

  private static Ontology __instance = new MarsOntology();

  public static final String __NAME = "mars_project_MarsOntology";

  public static Ontology getInstance() {
    return __instance;
  }

  public static DoNextSlot DoNextSlot() {
    return new DoNextSlot();
  }

  public static DoMoveTowards DoMoveTowards(final Integer targetX, final Integer targetY) {
    return new DoMoveTowards(targetX, targetY);
  }

  public static DoPick DoPick() {
    return new DoPick();
  }

  public static DoDrop DoDrop() {
    return new DoDrop();
  }

  public static DoBurn DoBurn() {
    return new DoBurn();
  }

  public static Percepts Percepts(final Integer myX, final Integer myY, final Integer r2X, final Integer r2Y, final Boolean hasGarbage) {
    return new Percepts(myX, myY, r2X, r2Y, hasGarbage);
  }

  public static PickedSuccessfully PickedSuccessfully() {
    return new PickedSuccessfully();
  }

  public static PickFailed PickFailed() {
    return new PickFailed();
  }

  public static GarbageAtBase GarbageAtBase() {
    return new GarbageAtBase();
  }

  public static ActionCompleted ActionCompleted() {
    return new ActionCompleted();
  }

  public MarsOntology() {
    super(__NAME, jadescript.content.onto.Ontology.getInstance(), new jade.content.onto.CFReflectiveIntrospector());
    try {
    	
    	
    	add(new jade.content.schema.AgentActionSchema(DoNextSlot), DoNextSlot.class);
    	add(new jade.content.schema.AgentActionSchema(DoMoveTowards), DoMoveTowards.class);
    	add(new jade.content.schema.AgentActionSchema(DoPick), DoPick.class);
    	add(new jade.content.schema.AgentActionSchema(DoDrop), DoDrop.class);
    	add(new jade.content.schema.AgentActionSchema(DoBurn), DoBurn.class);
    	add(new jade.content.schema.PredicateSchema(Percepts), Percepts.class);
    	add(new jade.content.schema.PredicateSchema(PickedSuccessfully), PickedSuccessfully.class);
    	add(new jade.content.schema.PredicateSchema(PickFailed), PickFailed.class);
    	add(new jade.content.schema.PredicateSchema(GarbageAtBase), GarbageAtBase.class);
    	add(new jade.content.schema.PredicateSchema(ActionCompleted), ActionCompleted.class);
    	
    	
    	
    	
    	jade.content.schema.AgentActionSchema _asDoNextSlot = (jade.content.schema.AgentActionSchema) getSchema(DoNextSlot);
    
    	jade.content.schema.AgentActionSchema _asDoMoveTowards = (jade.content.schema.AgentActionSchema) getSchema(DoMoveTowards);
    _asDoMoveTowards.add(DoMoveTowards_targetX, (jade.content.schema.PrimitiveSchema) getSchema(jade.content.onto.BasicOntology.INTEGER));
    _asDoMoveTowards.add(DoMoveTowards_targetY, (jade.content.schema.PrimitiveSchema) getSchema(jade.content.onto.BasicOntology.INTEGER));
    
    	jade.content.schema.AgentActionSchema _asDoPick = (jade.content.schema.AgentActionSchema) getSchema(DoPick);
    
    	jade.content.schema.AgentActionSchema _asDoDrop = (jade.content.schema.AgentActionSchema) getSchema(DoDrop);
    
    	jade.content.schema.AgentActionSchema _asDoBurn = (jade.content.schema.AgentActionSchema) getSchema(DoBurn);
    
    	jade.content.schema.PredicateSchema _psPercepts = (jade.content.schema.PredicateSchema) getSchema(Percepts);
    _psPercepts.add(Percepts_myX, (jade.content.schema.PrimitiveSchema) getSchema(jade.content.onto.BasicOntology.INTEGER));
    _psPercepts.add(Percepts_myY, (jade.content.schema.PrimitiveSchema) getSchema(jade.content.onto.BasicOntology.INTEGER));
    _psPercepts.add(Percepts_r2X, (jade.content.schema.PrimitiveSchema) getSchema(jade.content.onto.BasicOntology.INTEGER));
    _psPercepts.add(Percepts_r2Y, (jade.content.schema.PrimitiveSchema) getSchema(jade.content.onto.BasicOntology.INTEGER));
    _psPercepts.add(Percepts_hasGarbage, (jade.content.schema.PrimitiveSchema) getSchema(jade.content.onto.BasicOntology.BOOLEAN));
    
    } catch (jade.content.onto.OntologyException e) {
    	e.printStackTrace();
    }
  }
}
