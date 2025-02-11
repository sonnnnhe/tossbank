export default function Aside() {
  return (
    <div className="flex flex-col w-[1500px] border-2 border-green-500 p-4">
      <h4 className="font-bold">Golden Retriever</h4>
      <img
        src="src\dog.jpg"
        alt="리트리버"
        className="w-[200px] h-[200px] object-cover"
      />
      <ul>
        <li>● 기본특성</li>
        <li>● 단점</li>
        <li>● 키울 시 주의점</li>
        <li>● 파생 혼종견</li>
      </ul>
    </div>
  );
}
