import React from "react";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import Typography from "@mui/material/Typography";
import Stack from "@mui/material/Stack";
import Box from "@mui/material/Box";

const ParameterCard = ({ parameter, onClick }) => {
  const { id, name, type, value } = parameter;
  return (
    <Card
      onClick={onClick}
      variant="outlined"
      sx={{
        border: "1px solid #ccc",
        boxShadow: "0 0 10px #ccc",
        margin: "5px",
      }}
    >
      <CardContent>
        <Stack spacing={2}>
          <Typography variant="h5" component="h2" sx={{ fontWeight: "bold" }}>
            {name}
          </Typography>
          <Box>
            <Typography color="textSecondary">Id: {id}</Typography>
            <Typography color="textSecondary">Type: {type}</Typography>
            <Typography color="textSecondary">Value: {value}</Typography>
          </Box>
        </Stack>
      </CardContent>
    </Card>
  );
};

export default ParameterCard;
