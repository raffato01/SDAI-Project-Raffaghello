package mars_project;

import jade.content.ContentManager;
import jade.content.lang.Codec;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;
import jadescript.content.JadescriptProposition;
import jadescript.core.Agent;
import jadescript.core.exception.ExceptionThrower;
import jadescript.core.exception.JadescriptException;
import jadescript.java.AgentEnv;
import jadescript.java.JadescriptAgentController;
import jadescript.java.SideEffectsFlag;

@SuppressWarnings("all")
public class PatrolAgent extends Agent {
  private PatrolAgent __theAgent = (mars_project.PatrolAgent)/*Used as metadata*/null;

  private AgentEnv<PatrolAgent, SideEffectsFlag.AnySideEffectFlag> _agentEnv = null;

  public MarsOntology __ontology__mars_project_MarsOntology = (mars_project.MarsOntology) mars_project.MarsOntology.getInstance();

  public void __registerOntologies(final ContentManager cm) {
    super.__registerOntologies(cm);
    cm.registerOntology(mars_project.MarsOntology.getInstance());
  }

  public Codec __codec = new jade.content.lang.leap.LEAPCodec();

  protected Integer myX = null;

  public void setMyX(final Integer myX) {
    this.myX = myX;
  }

  public Integer getMyX() {
    return this.myX;
  }

  protected Integer myY = null;

  public void setMyY(final Integer myY) {
    this.myY = myY;
  }

  public Integer getMyY() {
    return this.myY;
  }

  protected Integer r2X = null;

  public void setR2X(final Integer r2X) {
    this.r2X = r2X;
  }

  public Integer getR2X() {
    return this.r2X;
  }

  protected Integer r2Y = null;

  public void setR2Y(final Integer r2Y) {
    this.r2Y = r2Y;
  }

  public Integer getR2Y() {
    return this.r2Y;
  }

  protected Integer lastX = null;

  public void setLastX(final Integer lastX) {
    this.lastX = lastX;
  }

  public Integer getLastX() {
    return this.lastX;
  }

  protected Integer lastY = null;

  public void setLastY(final Integer lastY) {
    this.lastY = lastY;
  }

  public Integer getLastY() {
    return this.lastY;
  }

  private void __onCreate() {
    try {
    	/* 
    	 * Compiled from source statement at line 15
    	 * log "r3 (PatrolAgent) started [Modular Behaviours]. Scanning rows 4-6."
    	 */
    	
    	jadescript.core.Agent.doLog(jade.util.Logger.INFO, PatrolAgent.this.getClass().getName(), PatrolAgent.this, "on create", java.lang.String.valueOf("r3 (PatrolAgent) started [Modular Behaviours]. Scanning rows 4-6."));
    	
    	/* 
    	 * Compiled from source statement at line 16
    	 * activate PatrolGrid
    	 */
    	
    	new mars_project.PatrolGrid(_agentEnv.getAgent().toEnv()).activate(_agentEnv.getAgent());
    }
    catch(jadescript.core.exception.JadescriptException __throwable) {
    	__handleJadescriptException(__throwable);
    }
    catch(java.lang.Throwable __throwable) {
    	__handleJadescriptException(jadescript.core.exception.JadescriptException.wrap(__throwable));
    }
  }

  private ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__DEFAULT_THROWER;

  public void __handleJadescriptException(final JadescriptException __exc) {
    jadescript.core.exception.ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__getExceptionEscalator(PatrolAgent.this);
    boolean __handled = false;
    if(!__handled) {
    	__thrower.__throwJadescriptException(__exc);
    }
  }

  public void __handleBehaviourFailure(final jadescript.core.behaviours.Behaviour<?> __behaviour, final JadescriptProposition __reason) {
    boolean __handled = false;
    if(!__handled) {
    	jadescript.core.Agent.doLog(java.util.logging.Level.INFO, this.getClass().getName(), this, "<behaviour failure dispatcher>", "Behaviour " + __behaviour + " failed with reason: " + __reason);
    }
  }

  private void __initializeProperties() {
    // Initializing properties and event handlers:
    {
    	PatrolAgent.this.myX = 0;
    	
    	PatrolAgent.this.myY = 4;
    	
    	PatrolAgent.this.r2X = 3;
    	
    	PatrolAgent.this.r2Y = 3;
    	
    	PatrolAgent.this.lastX = 0;
    	
    	PatrolAgent.this.lastY = 4;
    }
  }

  private void __initializeAgentEnv() {
    this._agentEnv = jadescript.java.AgentEnv.agentEnv(__theAgent());
  }

  public PatrolAgent __theAgent() {
    return this;
  }

  protected void setup() {
    super.setup();
    __initializeAgentEnv();
    __initializeProperties();
    this.__onCreate();
  }

  protected void __registerCodecs(final ContentManager cm) {
    super.__registerCodecs(cm);
    cm.registerLanguage(__codec);
  }

  public static JadescriptAgentController create(final ContainerController _container, final String _agentName) throws StaleProxyException {
    return jadescript.java.JadescriptAgentController.createRaw(_container, _agentName, mars_project.PatrolAgent.class);
  }
}
