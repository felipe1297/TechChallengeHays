export default function AreAllPropertiesNonEmpty(obj) {
  return Object.values(obj).every((value) => {
    if (typeof value === "number" || typeof value === "boolean") {
      return true;
    }
    return value != null && value !== "";
  });
}
