package mars_project;

import jade.content.onto.Ontology;
import jadescript.content.JadescriptAtomicProposition;

@SuppressWarnings("all")
public class PickedSuccessfully implements JadescriptAtomicProposition {
  public String toString() {
    java.lang.StringBuilder _sb = new java.lang.StringBuilder();
    _sb.append("mars_project.PickedSuccessfully");
    return _sb.toString();
  }

  public boolean equals(final Object obj) {
    if(obj instanceof PickedSuccessfully) {
    	PickedSuccessfully o = (PickedSuccessfully) obj;
    	return true;
    } else {
    	return super.equals(obj);
    }
  }

  public PickedSuccessfully() {
    {
    }
  }

  public Ontology __getDeclaringOntology() {
    return mars_project.MarsOntology.getInstance();
  }

  private MarsOntology __metadata_mars_project_PickedSuccessfully() {
    return null;
  }
}
