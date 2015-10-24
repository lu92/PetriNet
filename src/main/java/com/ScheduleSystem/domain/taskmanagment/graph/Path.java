package com.ScheduleSystem.domain.taskmanagment.graph;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by SG0222895 on 7/24/2015.
 */
@Data
public final class Path
{
    private List<Node> pathVertices = new ArrayList<>();

    public Path()
    {
    }

    public Path(Node ... nodes)
    {
        pathVertices.addAll(Arrays.asList(nodes));
    }

    public static Path reversePath(Path path) {
        return path.reversePath();
    }

    public Path reversePath() {
        Path reversedPath = new Path();
        for (int i=this.length()-1; i>=0; i--)
            reversedPath.addNodes(this.getNode(i));
        return reversedPath;
    }

    public void addNodes(Node ... nodes) {
        pathVertices.addAll(Arrays.asList(nodes));
    }

    public void removeNodes(Node ... nodes) {
        pathVertices.removeAll(Arrays.asList(nodes));
    }

    public boolean hasSubPath(Path subPath) {
        int n;
        for (int i=0; i<pathVertices.size(); i++) {
            n=0;
            for (int j=0; j<subPath.length(); j++) {
                if (pathVertices.get(i+j).equals(subPath.getNode(j)))
                    n++;
                else break;
            }
            if (n == subPath.length()) return true;
        }
        return false;
    }

    public Node getBeginNode() {
        return pathVertices.get(0);
    }

    public Node getEndNode() {
        return pathVertices.get(pathVertices.size()-1);
    }

    public Node getNode(int index) {
        return pathVertices.get(index);
    }

    public int length() {
        return pathVertices.size();
    }

    public void clear() {
        pathVertices.clear();
    }

    public boolean isEmpty() {
        return pathVertices.isEmpty();
    }

    @Override public String toString()
    {
        StringBuffer sb = new StringBuffer();
        for (Node node : pathVertices)
            sb.append(node.getName()+ ", ");

        return "Path{" +
                "pathVertices=" + sb.toString() +
                '}';
    }
}

