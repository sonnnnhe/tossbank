import Section from "./Section.jsx";
import Aside from "./Aside.jsx";

export default function Main2() {
  return (
    <div className="flex h-64">
      <Section />
      <Aside />
    </div>
  );
}

// const Main = () => {
//   return (
//     <div
//       id="main"
//       className="border border-black text-white bg-[#008B8B] text-[22px] flex flex-row flex-nowrap justify-center items-center h-[300px]"
//     >
//       <Section />
//       <Aside />
//     </div>
//   );
// };
