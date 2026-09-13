package mars_project;

import jade.content.onto.Ontology;
import jadescript.content.JadescriptAction;

@SuppressWarnings("all")
public class DoMoveTowards implements JadescriptAction {
  private Integer targetX;

  public Integer getTargetX() {
    return this.targetX;
  }

  public void setTargetX(final Integer targetX) {
    this.targetX = targetX;
  }

  private Integer targetY;

  public Integer getTargetY() {
    return this.targetY;
  }

  public void setTargetY(final Integer targetY) {
    this.targetY = targetY;
  }

  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("mars_project.DoMoveTowards");
    _sb.append("(");
    _sb.append(java.lang.String.valueOf(getTargetX()));
    _sb.append(", ");
    _sb.append(java.lang.String.valueOf(getTargetY()));
    _sb.append(")");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof DoMoveTowards) {
    	DoMoveTowards o = (DoMoveTowards) obj;
    	return true && java.util.Objects.equals(this.getTargetX(), o.getTargetX()) && java.util.Objects.equals(this.getTargetY(), o.getTargetY());
    } else {
    	return super.equals(obj);
    }
  }

  public DoMoveTowards() {
    {
    	this.setTargetX(0);
    	
    	this.setTargetY(0);
    }
  }

  public DoMoveTowards(final Integer targetX, final Integer targetY) {
    super();
    
    this.setTargetX(targetX);
    this.setTargetY(targetY);
  }

  public Ontology __getDeclaringOntology() {
    return mars_project.MarsOntology.getInstance();
  }

  private MarsOntology __metadata_mars_project_DoMoveTowards(final Integer targetX, final Integer targetY) {
    return null;
  }
}
