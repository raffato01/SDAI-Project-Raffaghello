package mars_project;

import jade.content.onto.Ontology;
import jadescript.content.JadescriptPredicate;

@SuppressWarnings("all")
public class Percepts implements JadescriptPredicate {
  private Integer myX;

  public Integer getMyX() {
    return this.myX;
  }

  public void setMyX(final Integer myX) {
    this.myX = myX;
  }

  private Integer myY;

  public Integer getMyY() {
    return this.myY;
  }

  public void setMyY(final Integer myY) {
    this.myY = myY;
  }

  private Integer r2X;

  public Integer getR2X() {
    return this.r2X;
  }

  public void setR2X(final Integer r2X) {
    this.r2X = r2X;
  }

  private Integer r2Y;

  public Integer getR2Y() {
    return this.r2Y;
  }

  public void setR2Y(final Integer r2Y) {
    this.r2Y = r2Y;
  }

  private Boolean hasGarbage;

  public Boolean getHasGarbage() {
    return this.hasGarbage;
  }

  public void setHasGarbage(final Boolean hasGarbage) {
    this.hasGarbage = hasGarbage;
  }

  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("mars_project.Percepts");
    _sb.append("(");
    _sb.append(java.lang.String.valueOf(getMyX()));
    _sb.append(", ");
    _sb.append(java.lang.String.valueOf(getMyY()));
    _sb.append(", ");
    _sb.append(java.lang.String.valueOf(getR2X()));
    _sb.append(", ");
    _sb.append(java.lang.String.valueOf(getR2Y()));
    _sb.append(", ");
    _sb.append(java.lang.String.valueOf(getHasGarbage()));
    _sb.append(")");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof Percepts) {
    	Percepts o = (Percepts) obj;
    	return true && java.util.Objects.equals(this.getMyX(), o.getMyX()) && java.util.Objects.equals(this.getMyY(), o.getMyY()) && java.util.Objects.equals(this.getR2X(), o.getR2X()) && java.util.Objects.equals(this.getR2Y(), o.getR2Y()) && java.util.Objects.equals(this.getHasGarbage(), o.getHasGarbage());
    } else {
    	return super.equals(obj);
    }
  }

  public Percepts() {
    {
    	this.setMyX(0);
    	
    	this.setMyY(0);
    	
    	this.setR2X(0);
    	
    	this.setR2Y(0);
    	
    	this.setHasGarbage(false);
    }
  }

  public Percepts(final Integer myX, final Integer myY, final Integer r2X, final Integer r2Y, final Boolean hasGarbage) {
    super();
    
    this.setMyX(myX);
    this.setMyY(myY);
    this.setR2X(r2X);
    this.setR2Y(r2Y);
    this.setHasGarbage(hasGarbage);
  }

  public Ontology __getDeclaringOntology() {
    return mars_project.MarsOntology.getInstance();
  }

  private MarsOntology __metadata_mars_project_Percepts(final Integer myX, final Integer myY, final Integer r2X, final Integer r2Y, final Boolean hasGarbage) {
    return null;
  }
}
