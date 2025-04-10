#!/bin/bash

set -e

echo "🔧 Permissões para gradlew..."
chmod +x ./gradlew

echo "🛠️ Build Android (composeApp)..."
./gradlew :composeApp:assembleDebug

echo "🍏 Build Kotlin/Native (iOS Arm64)..."
./gradlew :composeApp:compileKotlinIosArm64

echo "📱 Build iOS App com Xcode..."
xcodebuild \
  -project iosApp/iosApp.xcodeproj \
  -scheme iosApp \
  -sdk iphonesimulator \
  -configuration Debug \
  build

echo "✅ Tudo finalizado com sucesso!"
