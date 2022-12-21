fun solution(elements: MutableList<String>, index: Int) = elements.filterIndexed { num, _ -> num != index }
