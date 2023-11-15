import React from "react";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import Typography from "@mui/material/Typography";
import Stack from "@mui/material/Stack";
import Box from "@mui/material/Box";

const ToppingCard = ({ topping, onClick, isSelected  }) => {
  const { id , name , available , price , type } = topping;
  return (
    <Card
      onClick={onClick}
      variant="outlined"
      sx={{ border: isSelected ? "2px solid blue" : "1px solid #ccc" , boxShadow: "0 0 10px #ccc" , margin: "5px"}}
    >
      <CardContent>
        <Stack spacing={2}>
          <Typography variant="h5" component="h2" sx={{ fontWeight: "bold" }}>
            {name}
          </Typography>
          <Box>
            <Typography color="textSecondary">Id: {id}</Typography>
            <Typography color="textSecondary">Available: {available ? 'Yes' : 'No'}</Typography>
            <Typography color="textSecondary">Type: {type}</Typography>
            <Typography color="textSecondary">price: {price}</Typography>
          </Box>
        </Stack>
      </CardContent>
    </Card>
  );
};

export default ToppingCard;
