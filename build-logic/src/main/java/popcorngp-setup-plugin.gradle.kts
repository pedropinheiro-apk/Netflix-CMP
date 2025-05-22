import com.github.codandotv.popcorn.domain.input.PopcornChildConfiguration
import com.github.codandotv.popcorn.domain.input.ProjectType
import com.github.codandotv.popcorn.domain.rules.DoNotWithRule
import com.github.codandotv.popcorn.domain.rules.JustWithRule
import com.github.codandotv.popcorn.domain.rules.NoDependencyRule

plugins {
    id("io.github.codandotv.popcorngpparent")
}

popcornGuineapigParentConfig {
    type = ProjectType.KMP

    children = listOf(
        /**
         * core-shared-ui should only depends on core-shared
         */
        PopcornChildConfiguration(
            moduleNameRegex = ":core-shared-ui",
            rules = listOf(
                JustWithRule(
                    justWith = listOf("core-shared")
                )
            ),
        ),
        /**
         * core-shared should not have dependencies
         */
        PopcornChildConfiguration(
            moduleNameRegex = ":core-shared",
            rules = listOf(
                NoDependencyRule()
            ),
        ),
        /**
         * feature modules should not depend on each other
         */
        PopcornChildConfiguration(
            moduleNameRegex = ":feature-[a-z]+",
            rules = listOf(
                DoNotWithRule(
                    notWith = listOf(
                        ":feature-[a-z]+"
                    )
                ),
            ),
        ),
    )
}