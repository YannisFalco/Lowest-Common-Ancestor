package lcaDataStructure;

import java.util.ArrayList;
import java.util.List;

public class DGA {
    private List<NodeDouble> roots;

    DGA(){
        roots = new ArrayList<>();
    }

    DGA(List<NodeDouble> roots){
        this.roots = new ArrayList<>(roots);
    }

    public List<NodeDouble> getRoots() {
        return new ArrayList<>(roots);
    }
}
