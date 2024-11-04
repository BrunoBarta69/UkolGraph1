import java.util.*;

public class HlubokeProhledavani {

    private List<Integer> navstiveneVrcholy = new ArrayList<>();
    private Set<Integer> navstiveno = new HashSet<>();

    public List<Integer> prohledat(int pocatecniVrchol, Map<Integer, List<Integer>> graf) {
        projit(pocatecniVrchol, graf);
        return navstiveneVrcholy;
    }

    private void projit(int vrchol, Map<Integer, List<Integer>> graf) {
        if (navstiveno.contains(vrchol)) {
            return;
        }
        navstiveno.add(vrchol);
        navstiveneVrcholy.add(vrchol);

        for (int soused : graf.getOrDefault(vrchol, Collections.emptyList())) {
            projit(soused, graf);
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graf = new HashMap<>();
        graf.put(0, Arrays.asList(1, 2));
        graf.put(1, Arrays.asList(0, 3, 4));
        graf.put(2, Arrays.asList(0, 5));
        graf.put(3, Arrays.asList(1));
        graf.put(4, Arrays.asList(1, 5));
        graf.put(5, Arrays.asList(2, 4));

        HlubokeProhledavani prohledavani = new HlubokeProhledavani();
        List<Integer> vysledek = prohledavani.prohledat(0, graf);

        System.out.println("Pořadí projetých vrcholů: " + vysledek);
    }
}
