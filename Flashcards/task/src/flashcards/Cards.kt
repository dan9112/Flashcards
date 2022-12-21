package flashcards

/** Card collection functionality class */
sealed class Cards : Collection<Triple<String, String, Int>> {
    /** Adds the new card to the collection */
    abstract fun add(term: String, definition: String)

    /**
     * Checks for the presence of the card with the specified term
     * and returns true if it exists
     */
    abstract fun containsTerm(term: String): Boolean

    /**
     * Checks for the presence of a card with the specified
     * definition and returns true if it exists
     */
    abstract fun containsDefinition(definition: String): Boolean

    /**
     * Returns the term by its definition or null if there is no
     * such term in the collections
     */
    abstract fun getTerm(definition: String): String?

    /** Returns random card as pair */
    abstract fun getRandomCard(): Pair<String, String>

    /**
     * Removes the card from the collection by term and returns true
     * or, if there is no such term in the collection, returns false
     */
    open fun remove(term: String) = cardsErrors.remove(term) != null

    private val cardsErrors = mutableMapOf<String, Int>()

    /** Returns count of errors for the term */
    protected fun getErrorsCount(term: String) = cardsErrors[term] ?: 0

    /**
     * Adds cards to the collection, replacing when terms match an
     * already used card
     *
     * P.S. Not sure about error replacement
     */
    fun add(term: String, definition: String, errorCount: Int) {
        add(term, definition)
        if (errorCount > 0) cardsErrors[term] = errorCount
    }

    /** Returns a map with terms with the most errors */
    fun getHardestTerm() = with(cardsErrors) {
        filterValues { value -> value == maxByOrNull { it.value }!!.value }
    }

    /** Clears error statistics */
    fun resetErrors() = cardsErrors.clear()

    /** Increments error statistics for the term */
    fun wrongAnswer(term: String) {
        cardsErrors[term] = (cardsErrors[term] ?: 0) + 1
    }

    final override var size = 0

    final override fun containsAll(elements: Collection<Triple<String, String, Int>>): Boolean {
        elements.forEach { if (!contains(it)) return false }
        return true
    }

    /* First solution
    class CardsLists : Cards() {
        private var terms = mutableListOf<String>()
        private var definitions = mutableListOf<String>()

        override fun add(term: String, definition: String) {
            val index = terms.indexOf(term)
            if (index < 0) {
                ++size
                terms.add(term)
                definitions.add(definition)
            } else {
                definitions[index] = definition
            }
        }

        override fun remove(term: String): Boolean {
            super.remove(term)
            terms.forEachIndexed { index, s ->
                if (s == term) {
                    --size
                    terms.removeAt(index)
                    definitions.removeAt(index)
                    return true
                }
            }
            return false
        }

        override fun containsTerm(term: String) = terms.contains(term)
        override fun containsDefinition(definition: String) = definitions.contains(definition)

        override fun getTerm(definition: String) = definitions.indexOf(definition).let {
            if (it < 0) null
            else terms[it]
        }

        override fun getRandomCard() = Random.nextInt(size).let {
            terms[it] to definitions[it]
        }

        override fun iterator() = object : Iterator<Triple<String, String, Int>> {
            private var current = 0
            override fun hasNext() = (current < size).also {
                if (!it) current = 0
            }

            override fun next() = with(current++) {
                terms[this].let { Triple(it, definitions[this], getErrorsCount(it)) }
            }
        }

        override fun contains(element: Triple<String, String, Int>) =
            terms.indexOf(element.first) == definitions.indexOf(element.second)

        override fun isEmpty() = terms.isEmpty()
    }
     */

    /** Final solution */
    class CardsMap : Cards() {
        private val cards = mutableMapOf<String, String>()

        override fun add(term: String, definition: String) {
            if (cards[term] == null) ++size
            cards[term] = definition
        }

        override fun remove(term: String): Boolean {
            super.remove(term)
            return (cards.remove(term) != null).also { if (it) --size }
        }

        override fun containsTerm(term: String) = cards.containsKey(term)
        override fun containsDefinition(definition: String) = cards.containsValue(definition)
        override fun getTerm(definition: String) = cards.keys.firstOrNull { definition == cards[it] }
        override fun getRandomCard() = cards.keys.random().let { it to cards[it]!! }
        override fun iterator() = object : Iterator<Triple<String, String, Int>> {
            private val iterator = cards.iterator()
            override fun hasNext() = iterator.hasNext()

            override fun next() = with(iterator.next()) {
                Triple(key, value, getErrorsCount(key))
            }
        }

        override fun contains(element: Triple<String, String, Int>) = cards[element.first] == element.second
        override fun isEmpty() = cards.isEmpty()
    }
}
