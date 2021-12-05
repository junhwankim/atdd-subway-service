package nextstep.subway.line.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import nextstep.subway.common.SectionNotRemovableException;
import nextstep.subway.station.domain.Station;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SectionsTest {

    private Station 강남역;
    private Station 판교역;
    private Station 정자역;
    private Station 광교역;

    private Section 강남_판교_구간;
    private Section 정자_광교_구간;

    @BeforeEach
    void setUp() {
        강남역 = new Station("강남역");
        판교역 = new Station("판교역");
        정자역 = new Station("정자역");
        광교역 = new Station("광교역");

        강남_판교_구간 = Section.of(null, 강남역, 판교역, 5);
        정자_광교_구간 = Section.of(null, 정자역, 광교역, 10);
    }

    @Test
    void test_구간이_최소인_경우_제거_시도시_예외_발생() {
        Sections sections = new Sections();
        sections.addSection(강남_판교_구간);

        assertThatThrownBy(() -> sections.removeStation(null, 강남역))
            .isInstanceOf(SectionNotRemovableException.class);
    }
}