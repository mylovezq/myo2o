package com.imooc.myo2o.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;


import com.imooc.myo2o.dto.Result;


import com.imooc.myo2o.exceptions.HeadLineOperationException;

import com.imooc.myo2o.util.UploadController;
import com.imooc.myo2o.util.ZipImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.imooc.myo2o.dao.HeadLineDao;
import com.imooc.myo2o.dto.HeadLineExecution;
import com.imooc.myo2o.entity.HeadLine;
import com.imooc.myo2o.enums.HeadLineStateEnum;
import com.imooc.myo2o.service.HeadLineService;


@Service
public class HeadLineServiceImpl implements HeadLineService {

	@Autowired
	private HeadLineDao headLineDao;

	@Override
	public List<HeadLine> getHeadLineList(HeadLine headLineCondition) throws IOException {
		List<HeadLine> headLineList = null;
		headLineList = headLineDao.queryHeadLine(headLineCondition);
		return headLineList;
	}

	@Override
	@Transactional
	public HeadLineExecution addHeadLine(HeadLine headLine, MultipartFile thumbnail) {
		if (headLine != null) {
			headLine.setCreateTime(new Date());
			headLine.setLastEditTime(new Date());
			if (thumbnail != null) {
				upImage(headLine, thumbnail);
			}
			try {
				int effectedNum = headLineDao.insertHeadLine(headLine);
				if (effectedNum > 0) {
					return new HeadLineExecution(HeadLineStateEnum.SUCCESS, headLine);
				} else {
					return new HeadLineExecution(HeadLineStateEnum.INNER_ERROR);
				}
			} catch (Exception e) {
				throw new RuntimeException("添加头条信息失败:" + e.toString());
			}
		} else {
			return new HeadLineExecution(HeadLineStateEnum.EMPTY);
		}
	}

	@Override
	@Transactional
	public HeadLineExecution modifyHeadLine(HeadLine headLine, MultipartFile thumbnail) {
		if (headLine.getLineId() != null && headLine.getLineId() > 0) {
			headLine.setLastEditTime(new Date());
			if (thumbnail != null) {
				upImage(headLine, thumbnail);
			}
			try {
				int effectedNum = headLineDao.updateHeadLine(headLine);
				if (effectedNum > 0) {
					return new HeadLineExecution(HeadLineStateEnum.SUCCESS, headLine);
				} else {
					return new HeadLineExecution(HeadLineStateEnum.INNER_ERROR);
				}
			} catch (Exception e) {
				throw new RuntimeException("更新头条信息失败:" + e.toString());
			}
		} else {
			return new HeadLineExecution(HeadLineStateEnum.EMPTY);
		}
	}

	@Override
	@Transactional
	public HeadLineExecution removeHeadLine(long headLineId) {
		if (headLineId > 0) {
			try {
				int effectedNum = headLineDao.deleteHeadLine(headLineId);
				if (effectedNum > 0) {
					return new HeadLineExecution(HeadLineStateEnum.SUCCESS);
				} else {
					return new HeadLineExecution(HeadLineStateEnum.INNER_ERROR);
				}
			} catch (Exception e) {
				throw new RuntimeException("删除头条信息失败:" + e.toString());
			}
		} else {
			return new HeadLineExecution(HeadLineStateEnum.EMPTY);
		}
	}

	@Override
	@Transactional
	public HeadLineExecution removeHeadLineList(List<Long> headLineIdList) {
		if (headLineIdList != null && headLineIdList.size() > 0) {
			try {
				List<HeadLine> headLineList = headLineDao.queryHeadLineByIds(headLineIdList);
				int effectedNum = headLineDao.batchDeleteHeadLine(headLineIdList);
				if (effectedNum > 0) {
					return new HeadLineExecution(HeadLineStateEnum.SUCCESS);
				} else {
					return new HeadLineExecution(HeadLineStateEnum.INNER_ERROR);
				}

			} catch (Exception e) {
				throw new RuntimeException("删除头条信息失败:" + e.toString());
			}
		} else {
			return new HeadLineExecution(HeadLineStateEnum.EMPTY);
		}
	}

	private HeadLineOperationException upImage(HeadLine headLine, MultipartFile headLineThumbnail) {
		if (headLineThumbnail != null) {
			Result<String> upImgResult = new UploadController().upload(ZipImg.zipImgs(headLineThumbnail));
			if (upImgResult.isSuccess()) {
				headLine.setLineImg(upImgResult.getData());
			} else {
				throw new RuntimeException("addImgAdd(缩略图) error: " + upImgResult.getErrorMsg());
			}
		} else {
			throw new RuntimeException("addImgAdd(缩略图) error: " + "缩略图为空");
		}
		return new HeadLineOperationException(HeadLineStateEnum.EMPTY.getStateInfo());
	}
}






