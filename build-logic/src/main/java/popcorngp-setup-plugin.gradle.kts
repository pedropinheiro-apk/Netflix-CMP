import com.github.codandotv.popcorn.domain.input.PopcornChildConfiguration
import com.github.codandotv.popcorn.domain.input.ProjectType
import com.github.codandotv.popcorn.domain.rules.DoNotWithRule

plugins {
    id("io.github.codandotv.popcorngpparent")
}

popcornGuineapigParentConfig {
    type = ProjectType.KMP

    children = listOf(
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