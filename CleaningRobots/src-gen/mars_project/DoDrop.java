package mars_project;

import jade.content.onto.Ontology;
import jadescript.content.JadescriptAction;

@SuppressWarnings("all")
public class DoDrop implements JadescriptAction {
  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("mars_project.DoDrop");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof DoDrop) {
    	DoDrop o = (DoDrop) obj;
    	return true;
    } else {
    	return super.equals(obj);
    }
  }

  public DoDrop() {
    {
    }
  }

  public Ontology __getDeclaringOntology() {
    return mars_project.MarsOntology.getInstance();
  }

  private MarsOntology __metadata_mars_project_DoDrop() {
    return null;
  }
}
