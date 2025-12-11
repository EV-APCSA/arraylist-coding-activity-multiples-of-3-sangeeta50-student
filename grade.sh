#!/usr/bin/env bash
set -e

# Run Maven tests in quiet mode. We capture all output.
# If tests fail, we DON'T want the script to exit with non-zero,
# because we still want to compute partial credit.
mvn -B -q test > test-output.txt || true

# Points per test (keep in sync with NumberListTest.java)
score=0

add_points_if_present() {
  local test_name="$1"
  local pts="$2"
  if grep -q "$test_name" test-output.txt; then
    score=$((score + pts))
  fi
}

# JUnit 5 prints lines like:
#  "NumberListTest > multiplesOf3_notNullAndSize() PASSED"
# So we search for the test method names.

add_points_if_present "multiplesOf3_notNullAndSize" 3
add_points_if_present "multiplesOf3_firstAndLastValues" 3
add_points_if_present "multiplesOf3_fullSequenceCorrect" 4
add_points_if_present "toString_notNullAndHasNewlines" 3
add_points_if_present "toString_containsAllNumbersInOrder" 3
add_points_if_present "removeEvens_removesAllEvenNumbers" 2
add_points_if_present "removeEvens_resultsInCorrectOddSequence" 2

# Print the score in a format GitHub Classroom can understand.
# It just cares about a line like: "score: N"
echo "score: $score"
echo "Total points (max 20): $score"
echo
echo "Raw test output (for debugging):"
cat test-output.txt
