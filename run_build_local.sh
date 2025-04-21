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

echo "🧪 Rodando testes Android/KMP..."
./gradlew testDebugUnitTest

echo "🧪 Rodando testes iOS/KMP..."
./gradlew iosSimulatorArm64Test

echo "🧪 Rodando Kover"
./gradlew koverHtmlReport


#xcodebuild \
#  -project iosApp/iosApp.xcodeproj \
#  -scheme iosApp \
#  -sdk iphonesimulator \
#  -destination 'platform=iOS Simulator,name=iPhone 14' \
#  test

echo "✅ Tudo finalizado com sucesso!"
