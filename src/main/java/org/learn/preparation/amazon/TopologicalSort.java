package org.learn.preparation.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TopologicalSort {

    static class Build {
        int version;
        List<Build> dependencies;

        Build(int version, List<Build> dependencies) {
            this.version = version;
            this.dependencies = dependencies;
        }

        Build(int version) {
            this.version = version;
            this.dependencies = new ArrayList<>();
        }
    }

    public void generateDependencyTree(List<Build> builds) {

        //stack
        List<Integer> stack = new ArrayList<>();
        Set<Integer> visitedBuild = new HashSet<>();

        for (Build build : builds) {
            process(stack, visitedBuild, build);
        }

        System.out.println("path: " + Arrays.toString(stack.toArray()));

    }

    private void process(List<Integer> stack, Set<Integer> visitedBuild, Build build) {
        if (!visitedBuild.contains(build.version)) {
            visitedBuild.add(build.version);
            if (build.dependencies != null && build.dependencies.size() != 0) {
                build.dependencies.forEach(b ->
                        process(stack, visitedBuild, b)
                );
            }
            stack.add(build.version);
        }
    }

    public static void main(String[] args) {

        Build build0 = new Build(0);


        //2
        List<Build> build2Dependencies = new ArrayList<>();
        build2Dependencies.add(build0);
        Build build2 = new Build(2, build2Dependencies);

        // 1
        List<Build> build1Dependencies = new ArrayList<>();
        build1Dependencies.add(build0);
        build1Dependencies.add(build2);
        Build build1 = new Build(1, build1Dependencies);

        // 3
        List<Build> build3Dependencies = new ArrayList<>();
        build3Dependencies.add(build1);
        build3Dependencies.add(build2);
        Build build3 = new Build(3, build3Dependencies);

        // 4
        List<Build> build4Dependencies = new ArrayList<>();
        build4Dependencies.add(build3);
        Build build4 = new Build(4, build4Dependencies);

        List<Build> builds = new ArrayList<>();
        builds.add(build4);
        builds.add(build0);
        builds.add(build3);
        builds.add(build1);
        builds.add(build2);

        TopologicalSort topologicalSort = new TopologicalSort();
        topologicalSort.generateDependencyTree(builds);

    }

}
