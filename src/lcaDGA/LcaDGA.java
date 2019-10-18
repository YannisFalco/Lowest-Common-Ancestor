package lcaDGA;

import lcaDataStructure.DGA;
import lcaDataStructure.Node;
import lcaDataStructure.NodeDouble;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LcaDGA {

    private DGA dga;
    private List<NodeDouble> res;

    LcaDGA(DGA dga){
        this.dga = dga;
        res = new ArrayList<>();
    }

    List<NodeDouble> getLCAFromValue(List<Integer> nodesValue){
        this.dga.computeDepth();
        res = new ArrayList<>();
        List<NodeDouble> p = new ArrayList<>();
        for(NodeDouble nodeDouble : this.dga.getRoots()){
            if(nodesValue.contains(nodeDouble.getValue())){
                p.add(nodeDouble);
            }
            recursiveLCA(nodeDouble, nodesValue);
        }
        if(p.size()>0) return p;
        if(res.size() <1) return null;
        Iterator it = res.iterator();
        int max = res.get(0).getDepth();
        for(NodeDouble r : res ){
            if(r.getDepth()>max){
                max = r.getDepth();
            }
        }
        List<Integer> contained = new ArrayList<>();
        while(it.hasNext()){
            NodeDouble nodeDouble = (NodeDouble) it.next();
            if(nodeDouble.getDepth()<max || contained.contains(nodeDouble.getValue())) it.remove();
            else contained.add(nodeDouble.getValue());

        }
        return res;
    }

    private List<Integer> recursiveLCA(NodeDouble nodeDouble,List<Integer> value){

        List<Integer> ret = new ArrayList<>();
        List<NodeDouble> nodes = nodeDouble.getSons();

        for(NodeDouble node1 : nodes){
            List<Integer> res = new ArrayList<>(recursiveLCA(node1, value));
            for(int i=0; i<res.size(); i++){
                if(!ret.contains(res.get(i))){
                    ret.add(res.get(i));
                }
            }
        }
        if(ret.size() == value.size()) {
            this.res.add(nodeDouble);
        }
        if(value.contains(nodeDouble.getValue()) && !ret.contains(nodeDouble.getValue())) {
            ret.add(nodeDouble.getValue());
        }
        return ret;
    }




}
