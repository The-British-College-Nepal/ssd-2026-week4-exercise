#!/usr/bin/env bash
# Quick-start helper script for students starting the SSD Week 4 exercise

set -e

echo "============================================================"
echo "🚀 Welcome to SSD Week 4: Exception Handling Lab!"
echo "   Module Lecturer: Sudan Pudasaini"
echo "   The British College (Leeds Beckett University)"
echo "============================================================"

# Check if on main branch
CURRENT_BRANCH=$(git rev-parse --abbrev-ref HEAD 2>/dev/null || echo "unknown")

if [ "$CURRENT_BRANCH" = "main" ]; then
  echo ""
  echo "🌿 In accordance with class policy, do NOT commit on 'main'."
  echo "   Creating a fresh feature branch for Step 1..."
  git checkout -b feature/step1-array-processor
  echo "✅ Switched to branch: feature/step1-array-processor"
else
  echo "ℹ️  Currently on branch: $CURRENT_BRANCH"
fi

echo ""
echo "🛠️  Running initial test check..."
if command -v mvn &> /dev/null; then
  mvn test -Dtest=Step1ArrayProcessorTest || true
elif [ -f "/Users/sudan/.m2/wrapper/dists/apache-maven-3.8.4-bin/52ccbt68d252mdldqsfsn03jlf/apache-maven-3.8.4/bin/mvn" ]; then
  /Users/sudan/.m2/wrapper/dists/apache-maven-3.8.4-bin/52ccbt68d252mdldqsfsn03jlf/apache-maven-3.8.4/bin/mvn test -Dtest=Step1ArrayProcessorTest || true
else
  echo "ℹ️  Maven command not found in default PATH. Ensure Maven 3.8+ is installed."
fi

echo ""
echo "👉 Open README.md in your IDE and follow Step 1 instructions!"
echo "   Good luck with Week 4!"
