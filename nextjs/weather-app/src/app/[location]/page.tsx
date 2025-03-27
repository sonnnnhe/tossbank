// 'use client'
// client component는 맨 말단으로 이동해야 한다.
// 왜? client component 밑에는 server component 사용 불가!!

import HomeButton from '../components/HomeButton'
import { getForecast } from '../utils/getForecast'

// import Link from 'next/link'

// 폴더명이 detail일 때 localhost:3000/detail 로 자동 라우팅

// 폴더명을 []로 감싸면 동적 라우팅이 됨
// localhost:3000/[location]
// localhost:3000/seoul
// localhost:3000/NYC
// localhost:3000/london

export function generateMetadata() {
  return {
    title: '상세 날씨 데이터',
    description: '상세 날씨 데이터입니다.',
  }
} // 페이지 별로 메타데이터 바꿀 수 있음

type Props = {
  params: {
    location: string
  }
  // params: Promise<{ location: string }>;
}

// next.js 13버전에서 async를 통해서 params 값을 얻어온다.
// client component의 경우, async 사용 불가
export default async function Detail({ params }: Props) {
  const { location } = params
  const name = location === 'seoul' ? '서울' : location

  const json = await getForecast(location)
  console.log(json)

  return (
    <>
      <h1>{name}의 3일치 날씨 예보</h1>
      <ul>
        {json.forecast.forecastday.map((day) => (
          <li key={day.date}>
            {day.date} / {day.day.avgtemp_c}℃
            <br />
            <img
              src={`http:${day.day.condition.icon}`}
              alt={day.day.condition.text}
            />
            <span>{day.day.condition.text}</span>
          </li>
        ))}
      </ul>
      {/* <Link href="/">홈으로</Link> */}
      <br />
      <HomeButton />
    </>
  )
}
