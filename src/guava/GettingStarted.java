package guava;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;
import com.google.common.io.Files;
import com.google.common.primitives.Ints;

public class GettingStarted {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// 读文件 （Files）
		File file = new File(
				"D:/src/java_workspace/ExerciseBook/resources/1C.txt");
		List<String> lines = null;
		try {
			lines = Files.readLines(file, Charsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Ints & join & splitter
		int[] numbers = { 1, 2, 3, 4, 5 };
		int a = 4;
		System.out.println(Ints.max(numbers));
		System.out.println(Ints.min(numbers));
		System.out.println(Ints.compare(1, 2));
		System.out.println(Ints.contains(numbers, a));
		System.out.println(Ints.indexOf(numbers, a));
		numbers = Ints.concat(numbers, new int[] { 6, 7, 8 });

		String numbersAsString = Ints.join(";", numbers);
		System.out.println(numbersAsString);
		Iterable<String> pieces = Splitter.on(";").split(numbersAsString);
		for (String piece : pieces) {
			System.out.println(piece);
		}
		String testString = "foo , what,,,more,";
		pieces = Splitter.on(",").omitEmptyStrings().trimResults()
				.split(testString);
		for (String piece : pieces) {
			System.out.println(piece);
		}

		// 文本中留下数字
		// print : 89983
		System.out.println(CharMatcher.DIGIT
				.retainFrom("some text 89983 and more"));
		// 文本中去掉数字
		// print : some text and more
		System.out.println(CharMatcher.DIGIT
				.removeFrom("some text 89983 and more"));

		// 集合
		HashSet<Integer> setA = Sets.newHashSet(1, 2, 3, 4, 5);
		HashSet<Integer> setB = Sets.newHashSet(4, 5, 6, 7, 8);

		SetView<Integer> union = Sets.union(setA, setB);
		System.out.println("union:");
		for (Integer integer : union)
			System.out.println(integer);

		SetView<Integer> difference = Sets.difference(setA, setB);
		System.out.println("difference:");
		for (Integer integer : difference)
			System.out.println(integer);

		SetView<Integer> intersection = Sets.intersection(setA, setB);
		System.out.println("intersection:");
		for (Integer integer : intersection)
			System.out.println(integer);

		// Map<String, Map<Long, List<String>>> map =
		// new HashMap<String, Map<Long,List<String>>>();
		Map<String, Map<Long, List<String>>> newMap = Maps.newHashMap();

		// List<String> list = new ArrayList<String>();
		// list.add("a");
		// list.add("b");
		// 不可变集合
		ImmutableList<String> immList = ImmutableList.of("a", "b", "c", "d");
		ImmutableMap<String, String> immMap = ImmutableMap.of("key1", "value1",
				"key2", "value2");

		// Map<K, List<V>>
		Multimap<String, String> multimap = ArrayListMultimap.create();

		// MapDifference differenceMap = Maps.difference(mapA, mapB);
		//
		// differenceMap.areEqual();
		// Map entriesDiffering = differenceMap.entriesDiffering();
		// Map entriesOnlyOnLeft = differenceMap.entriesOnlyOnLeft();
		// Map entriesOnlyOnRight = differenceMap.entriesOnlyOnRight();
		// Map entriesInCommon = differenceMap.entriesInCommon();

		// Preconditions
		try {
			String title = null;
			Preconditions.checkNotNull(title);
		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	// public boolean equals(Object o) {
	// if (o instanceof Order) {
	// Order that = (Order) o;
	//
	// return Objects.equal(address, that.address)
	// && Objects.equal(targetArrivalDate, that.targetArrivalDate)
	// && Objects.equal(lineItems, that.lineItems);
	// } else {
	// return false;
	// }
	// }
	//
	// public int hashCode() {
	// return Objects.hashCode(address, targetArrivalDate, lineItems);
	// }
}
