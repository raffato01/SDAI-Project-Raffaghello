package mars_project;

import jade.content.onto.Ontology;
import jadescript.content.JadescriptAction;

@SuppressWarnings("all")
public class DoBurn implements JadescriptAction {
  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("mars_project.DoBurn");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof DoBurn) {
    	DoBurn o = (DoBurn) obj;
    	return true;
    } else {
    	return super.equals(obj);
    }
  }

  public DoBurn() {
    {
    }
  }

  public Ontology __getDeclaringOntology() {
    return mars_project.MarsOntology.getInstance();
  }

  private MarsOntology __metadata_mars_project_DoBurn() {
    return null;
  }
}
