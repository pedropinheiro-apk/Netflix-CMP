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
        PopcornChildConfiguration(
            moduleNameRegex = ":core-[a-z]+",
            rules = listOf(
                NoDependencyRule(),
            ),
        ),
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